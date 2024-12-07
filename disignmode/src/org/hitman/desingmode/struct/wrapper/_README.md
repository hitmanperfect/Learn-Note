## 解决的问题 or 思想
动态增强类的功能

## 角色
- 基类，被扩展的类，一般会有一个接口和一个impl 类
- wrapper类，
  - 如果会有多个wrapper，可以抽象出一个基类
- client

## demo - Android
- ContextImpl, 被扩展的基类
- ContextWrapper, 装饰者基类，
  - Activity
  - Service

## 和代理模式区别
代理模式，主要是对基类的控制，对原接口的一些hook，或log打印，或参数修改==
装饰者模式，主要是对基类的功能增强，增强的能力跟原先接口没啥关系