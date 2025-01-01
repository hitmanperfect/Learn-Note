package jjava.annotation;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Names;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import java.io.File;
import java.util.Set;
@SupportedAnnotationTypes("annotation.Data")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class DataAnnotationProcessor extends AbstractProcessor {
	private JavacTrees javacTrees;
	private TreeMaker treeMaker;
	private Names names;
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
	  super.init(processingEnv);
	  Context context = ((JavacProcessingEnvironment)processingEnv).getContext();
	  javacTrees = JavacTrees.instance(context);
	  treeMaker = TreeMaker.instance(context);
	  names = Names.instance(context);
	  System.out.println("init processor");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(Data.class);
        Class cls = this.getClass();
	  MethodSpec main = MethodSpec.methodBuilder("main")
		    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
		    .returns(void.class)
		    .addParameter(String[].class, "args")
		    .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
		    .build();

	  TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
		    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
		    .addMethod(main)
		    .build();

	  JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
		    .build();
	  try {
		javaFile.writeTo(System.out);
		File outPut = new File("src/");
		javaFile.writeTo(outPut);
	  } catch (Exception e) {
		e.printStackTrace();
	  }
//	  for (Element e:set) {
//		JCTree tree = javacTrees.getTree(e);
//		tree.accept(new TreeTranslator(){
//		    @Override
//		    public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {
//		        jcClassDecl.defs.stream().filter(it->it.getKind().equals(Tree.Kind.VARIABLE))
//				    .map(it->(JCTree.JCVariableDecl) it).forEach( it->{
//				        jcClassDecl.defs = jcClassDecl.defs.prepend();
//				        jcClassDecl.defs = jcClassDecl.defs.prepend();
//			  });
//			  super.visitClassDef(jcClassDecl);
//		    }
//		});
//	  }
	  return true;
    }

//    private JCTree.JCMethodDecl genGetterMethod(JCTree.JCVariableDecl jcVariableDecl){
//        JCTree.JCReturn jcReturn = treeMaker.Return(treeMaker.Select(treeMaker.Ident(names.fromString("this")),
//		    jcVariableDecl.getName()));
//	  ListBuffer<JCTree.JCStatement> statements = new ListBuffer<JCTree.JCStatement>().append(jcReturn);
//	  JCTree.JCModifiers modifiers = treeMaker.Modifiers(Flags.PUBLIC);
//	  Name getMethodName = getMethodName(jcVariableDecl.getName());
//    }
}
