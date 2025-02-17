##  小结
#### 先序遍历
遍历顺序是 根-左-右
  - 入栈访问节点：左节点先入栈即可，右节点再入栈，无需分层
  - 出栈访问节点：需要根节点先入栈、再出栈、出栈后 右节点先入栈，左节点再入栈，需要分层去遍历。

#### 中序遍历
遍历顺序是 左-根-右

#### 后序遍历
遍历顺序是 左-右-根 ，可以由 先序转化而来，先序是 根-左-右，取反后是 右-左-根，这一步可以通过双向序列搞定
平时都是 add() 等同于 addLast、即在尾部添加数据，只需改为 **addFirst** 即可,
关于 右-左，则是需要先记录右节点的值，再记录左节点的值
- 若是入栈记录阶段，则需先访问节点的右节点，再访问左节点
- 若是出栈记录，则由于是出栈（本身带一个取反逻辑）,则需要左节点先入栈，右节点再入栈

大体总结就是：入栈时取值用的是深度遍历的思想，出栈时取值，
用的是广度遍历的思想， 先序和后序，都能用这两种思想解决。