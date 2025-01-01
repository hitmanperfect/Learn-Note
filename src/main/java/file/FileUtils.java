package file;

import java.io.*;
import java.lang.reflect.Method;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

public class FileUtils {
    private static final String TAG = "FileUtils";

    /* 当前指令集 */
    private static String currentInstructionSet = null;

    public static final String ROOT_FILE_PATH = "/";

    private static final int ENDHDR = 22;
    private static final int ENDSIG = 0x6054b50;
    /* Size of read buffer */
    private static final int BUFFER_SIZE = 8096;

    /**
     * 迁移文件
     *
     * @param sourceFile 源文件
     * @param targetFile 目标文件
     */
    public static void moveFile(File sourceFile, File targetFile) {
	  moveFile(sourceFile, targetFile, true);
    }

    /**
     * 迁移文件
     *
     * @param sourceFile       源文件
     * @param targetFile       目标文件
     * @param needDeleteSource 是否删除源文件
     */
    public static void moveFile(File sourceFile, File targetFile, boolean needDeleteSource) {
	  copyToFile(sourceFile, targetFile);
	  if (needDeleteSource) {
		sourceFile.delete();
	  }
    }

    /**
     * Copy data from a source stream to destFile. Return true if succeed,
     * return false if failed.
     *
     * @param srcFile  source file
     * @param destFile destFile
     * @return success return true
     */
    public static boolean copyToFile(File srcFile, File destFile) {
	  if (srcFile == null || !srcFile.exists() || destFile == null) {
		return false;
	  }

	  boolean result = false;
	  InputStream inputStream = null;
	  BufferedInputStream bis = null;
	  try {
		inputStream = new FileInputStream(srcFile);
		bis = new BufferedInputStream(inputStream);

		result = copyToFile(bis, destFile);
	  } catch (IOException e) {
		/* ignore */
	  } finally {
	  }

	  return result;
    }


    /**
     * Copy data from a source stream to destFile. Return true if succeed,
     * return false if failed.
     *
     * @param inputStream source file inputstream
     * @param destFile    destFile
     * @return success return true
     */
    public static boolean copyToFile(InputStream inputStream, File destFile) {
	  if (inputStream == null || destFile == null) {
		return false;
	  }

	  FileOutputStream out = null;
	  BufferedOutputStream bos = null;
	  try {
		if (destFile.exists()) {
		    destFile.delete();
		    destFile.createNewFile();
		}
		out = new FileOutputStream(destFile);
		bos = new BufferedOutputStream(out);
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) >= 0) {
		    bos.write(buffer, 0, bytesRead);
		}
		bos.flush();
		return true;
	  } catch (IOException e) {
		return false;
	  } finally {
	  }
    }

    /**
     * Deletes a directory recursively.
     *
     * @param directory directory to delete
     */
    public static boolean deleteDirectory(File directory) {
	  if (directory == null || !directory.exists()) {
		return true;
	  }

	  boolean deleted = cleanDirectoryContent(directory);
	  // delete directory self
	  return directory.delete() && deleted;
    }

    /**
     * Clean the content in the directory
     */
    public static boolean cleanDirectoryContent(File directory) {
	  if (directory == null || !directory.exists()) {
		return true;
	  }

	  boolean deleted = false;
	  try {
		cleanDirectory(directory);
		deleted = true;
	  } catch (Exception e) {
		// ignore
	  }
	  return deleted;
    }


    /**
     * Cleans a directory without deleting it.
     *
     * @param directory directory to clean
     * @throws IOException in case cleaning is unsuccessful
     */
    public static void cleanDirectory(File directory) throws IOException {
	  if (!directory.exists()) {
		String message = directory + " does not exist";
		throw new IllegalArgumentException(message);
	  }

	  if (!directory.isDirectory()) {
		String message = directory + " is not a directory";
		throw new IllegalArgumentException(message);
	  }

	  File[] files = directory.listFiles();
	  if (files == null) { // null if security restricted
		throw new IOException("Failed to list contents of " + directory);
	  }

	  IOException exception = null;
	  for (File file : files) {
		try {
		    forceDelete(file);
		} catch (IOException ioe) {
		    exception = ioe;
		}
	  }

	  if (null != exception) {
		throw exception;
	  }
    }

    /**
     * Deletes a file. If file is a directory, delete it and all
     * sub-directories. <p> The difference between File.delete() and this method
     * are: <ul> <li>A directory to be deleted does not have to be empty.</li>
     * <li>You get exceptions when a file or directory cannot be deleted.
     * (java.io.File methods returns a boolean)</li> </ul>
     *
     * @param file file or directory to delete, must not be <code>null</code>
     * @throws IOException  if the directory is <code>null</code>
     * @throws FileNotFoundException if the file was not found
     * @throws IOException           in case deletion is unsuccessful
     */
    public static void forceDelete(File file) throws IOException {
	  if (file.isDirectory()) {
		deleteDirectory(file);
	  } else {
		boolean filePresent = file.exists();
		if (!file.delete()) {
		    if (!filePresent) {
			  throw new FileNotFoundException("File does not exist: " + file);
		    }
		    String message = "Unable to delete file: " + file;
		    throw new IOException(message);
		}
	  }
    }


    public static boolean writeFile(String filePath, InputStream stream) {
	  return writeFile(filePath, stream, false);
    }

    public static boolean writeFile(String filePath, InputStream stream, boolean append) {
	  return writeFile(filePath != null ? new File(filePath) : null, stream, append);
    }

    public static boolean writeFile(File file, InputStream stream) {
	  return writeFile(file, stream, false);
    }

    public static boolean writeFile(File file, InputStream stream, boolean append) {
	  OutputStream o = null;
	  try {
		makeDirs(file.getAbsolutePath());
		o = new FileOutputStream(file, append);
		byte[] data = new byte[1024];
		int length;
		while ((length = stream.read(data)) >= 0) {
		    o.write(data, 0, length);
		}
		o.flush();
		return true;
	  } catch (FileNotFoundException e) {
		e.printStackTrace();
	  } catch (IOException e) {
		e.printStackTrace();
	  } finally {
	  }
	  return false;
    }

    public static boolean makeDirs(String filePath) {
	  String folderName = getFolderName(filePath);
	  if (TextUtils.isEmpty(folderName)) {
		return false;
	  }
	  File folder = new File(folderName);
	  boolean mkdirs = (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
	  return mkdirs;
    }

    public static String getFolderName(String filePath) {
	  if (TextUtils.isEmpty(filePath)) {
		return filePath;
	  }
	  int filePosi = filePath.lastIndexOf(File.separator);
	  return filePosi == -1 ? "" : filePath.substring(0, filePosi);
    }

    /**
     * 写入文件
     * @param file
     * @param str
     */
    public static boolean writeFile(String file, String str){
	  boolean result = true;
	  BufferedWriter out = null;
	  try {
		out = new BufferedWriter(
			  new OutputStreamWriter(
				    new FileOutputStream(file), "utf-8"));
		out.append(str);
	  }catch(Exception e){
		result = false;
	  }finally{
		try{
		    if(out!=null) out.close();
		}catch(Exception e){
		    result = false;
		}
	  }
	  return result;
    }



    /**
     *
     * @param filePath
     * @param b
     * @return
     */
    public static boolean writeFile(String filePath, byte b[]){
	  FileOutputStream fos = null;
	  try {
		fos = new FileOutputStream(filePath);
		fos.write(b);
		fos.flush();
		fos.close();
	  } catch (IOException e) {
		e.printStackTrace();
		return false;
	  } finally {
	  }
	  return true;
    }

    public static byte[] readByteArray(String filename) {
	  File f = new File(filename);
	  if (!f.exists()) {
		return null;
	  }
	  ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
	  BufferedInputStream in = null;
	  try {
		in = new BufferedInputStream(new FileInputStream(f));
		int buf_size = 1024;
		byte[] buffer = new byte[buf_size];
		int len = 0;
		while (-1 != (len = in.read(buffer, 0, buf_size))) {
		    bos.write(buffer, 0, len);
		}
		return bos.toByteArray();
	  } catch (IOException e) {
		e.printStackTrace();
	  } finally {
	  }
	  return null;
    }






    /**
     * Compute crc32 of the central directory of an apk. The central directory contains
     * the crc32 of each entries in the zip so the computed result is considered valid for the whole
     * zip file. Does not support zip64 nor multidisk but it should be OK for now since ZipFile does
     * not either.
     */


}
