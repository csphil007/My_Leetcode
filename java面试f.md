# Java





## 基础



### Jvm,jre,jdk?

Jvm:java virtual machine，

jre：java runtime environment，包含jvm的标准实现和java一些基本类库

jdk：java development kit，Java开发工具包，集成了jre和一些工具

jdk>jre>jvm

### java为什么能跨平台运行？

java程序编译之后生成class文件，不同平台的jvm执行class文件。

### ==和equals（）的区别？

1. ==对基本数据类型来说比较的是值，对引用数据类型来说比较的是地址。因为java是值传递，所以根本来说两者比较的都是值，只不过引用类型存的是地址。

2. equals（）不能判断基本数据类型，只能判断对象。当类没有重写equals（）时，相当于==，用来比较地址。当类重写equals（）时（比如string类），比较的就是对象的值。

### hashcode（）与equals（）的关系？

1. 当重写equals（）时，必须重写hashcode（）。hashcode（）能够减小查找成本，当判断两个对象是否相等时，首先调用hashcode（），假如不相等，证明对象不相等，如果相等，再调用equals（）来判断是否真的相等。

2. 所以，假如不重写的话，会出现equals（）相等但是hashcode（）不相等的情况。(因为重写了equals方法判断对象相等，但是不一定地址相等，所以hashcode会不相等)

### 基本类型的包装类的常量池技术了解吗？

1. Byte, Short, Integer, Long默认创建[-128, 127]的缓存数据。

2. Character创建了[0, 127]的缓存数据。超出范围会创建新的对象。

### 自动装箱和拆箱了解吗？

装箱就是将基本类型用对应的包装类包装起来

拆箱就是将包装类型转换为基本类型

### 面向对象三大特征？

1. 封装
2. 继承
3. 多态

### 接口和抽象类的共同和区别？

共同点：

1. 都不能被实例化
2. 接口的实现类和抽象类的子类必须实现了其中的方法后才能实例化

区别：

1. 接口主要用于对类的行为约束，实现了某个接口就具有了对应的行为。抽象类主要用于代码复用，强调所属关系。
2. 一个类只能继承一个类，但能继承多个接口。实现接口implement，继承抽象类extends
3. 接口方法默认public

### 深拷贝和浅拷贝的区别？引用拷贝？

引用拷贝就是新建一个引用指向同一个对象。

浅拷贝会创建新的对象，但是如果原对象内部的属性是引用类型的话，两者会共用同一个内部对象。

深拷贝会完全复制整个对象，包括这个对象的所有内部对象

### String类为什么不可变？

1. 用来保存字符串的数组被final修饰
2. string整个类final修饰
3. string类里也没有提供可以修改数组的函数

### StringBuilder和StringBuffer的区别？

1. 都继承自abstractstringbuilder类，提供了修改字符串的方法，不同于string每次都要创建新的string对象。

2. string是线程安全的，stringbuffer方法被synchronized修饰，所以是线程安全的，stringbuilder线程不安全。

### 反射机制的作用？

反射就是将类的各个组成部分封装为其他对象，这就是反射机制

1. 在运行时查询对象的类信息
2. 在运行时查询类的成员变量和方法
3. 在运行时调用对象的方法
4. 在运行时创建新的对象

### 获取class的对象的方法

class.forname()

类名.class

对象.getclass()

### 单例模式

确保一个类只有一个实例，不能被外界实例化，这个实例时当前类的成员变量，私有，static；

目的：减少资源的消耗

分为懒汉式和饿汉式

饿汉式：在编译的时候就创建对象

![image-20220417161758331](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220417161758331.png)

懒汉式：第一次调用的时候才被实例化

![image-20220417162159740](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220417162159740.png)

### 反射应用场景？

1. 工厂模式
2. 动态代理
3. 数据库jdbc
4. 分析类文件

### 什么是泛型？

泛型的本质就是参数化类型

### 为什么引入泛型？

1. 为了类型安全，编译时期就能检查类型不正确的异常
2. 消除强制类型转换
3. 效率更高一点，因为会在编译时期完成相应的工作，不需要jvm修改

### 类型擦除？

编译器将带有泛型的java代码生成普通的不带泛型的字节码。

### 泛型可以用在哪里？

泛型类

泛型接口

泛型方法



## 容器



### Arraylist和Linkedlist区别？

1. 两者都不是线程安全的。

2. arraylist底层数据结构是object数组，linkedlist底层数据结构是双向链表

3. arraylist插入删除操作较为复杂，如果插入删除的位置在数组末尾的话，复杂度为o（1），如果在任意位置的话为o（n - i）。linkedlist插入删除操作只要指针遍历到指定位置即可，复杂度为o（n）。

4. arraylist支持随机访问，为数组下标。linkedlist不支持随机访问。

5. arraylist内存空间占用主要为开创一段连续地址，linkedlist的内存空间占用为每一个结点都存有前后结点信息。

### Arraylist扩容机制？

无参数创建arraylist时，懒加载，只有添加元素时才分配容量，arraylist默认容量为10，当需要扩容时，arraylist会通过位运算先将旧容量扩为1.5倍，然后检查新容量是否大于最小需要容量，若大于，扩容完毕，若小于，则将最小需要容量作为新容量。最后检查新容量是否超出了arraylist定义的最大容量，若超出，调用hugecapacity（）来比较最小需要容量和arraylist定义的最大容量，若大于，则将arraylist定义的最大容量改为integer.max_value，否则，新容量大小为arraylist定义的最大容量。

### hashset怎么检查重复？

先将插入的元素的hashcode与其他加入过的元素的hashcode对比，若有相同的，调用equals（）检查是否相等，若相等，插入失败。

### HashMap扩容机制？

jdk 1.8之前hashmap底层是由数组+链表构成的（头插法），jdk 1.8之后，hashmap底层由数组+链表/红黑树构成（尾插法），当链表长度大于8时，会先判断数组长度是否大于64，若小于，则优先扩容数组，若大于，才将链表转化为红黑树，减少搜索时间。其默认数组大小为16，每次扩容都会扩为2倍，总是用2的幂作为哈希表的容量。jdk 1.8之后的hash方法会扰动4次，性能比jdk 1.8之前的差一点。hashmap是懒加载机制，只有第一次put数据的时候才会创建。负载因子默认0.75，加入红黑树是为了解决链化严重的问题。

### hashmap扩容后怎么迁移数据？()  ||||||||?

1. 没有链化，没有红黑树化的存有单个node的：根据新表的size计算他的新位置，然后迁过去
2. 链化的：拆成两个链表，高位链表和低位链表，低位不动，高位放到（原位置+扩容增加的长度）
3. 红黑树化：内部还维护链表，也是拆成高位链表和低位链表，低位不动，高位放到（原位置+扩容的增加的长度），假如新长度小于等于6，就链化

### HashMap和Hashtable的区别？

1. hashmap是非线程安全的，hashtable是线程安全的，因为hashtable内部方法基本经过synchronized修饰。
2. hashmap可以存储null值，其中key只能存一个，value可以存多个。hashtable不可以存储null值。
4. hashmap底层由数组+链表/红黑树构成，hashtable底层由数组+链表构成。

### HashMap和HashSet区别？

1. hashmap实现map接口，hashset实现set接口。

2. hashmap存储键值对，hashset存储对象。

3. hashmap用key算hashcode，hashset用对象算hashcode

### HashMap为什么容量总是2的幂？

因为hash % n == hash & （n - 1）的前提是n为2的幂。能够提高运算效率。

### hashmap在多线程环境下可能会发生什么问题？

进行put操作时，需要扩容的时候，多个线程去同时调整大小，这是处在同一位置的链表元素的位置会反过来，可能出现aba情况，形成循环链表

### Hashtable和ConcurrentHashMap区别？

1. jdk 1.8之前，concurrenthashmap用的是分段锁，jdk 1.8之后用的是synchronized和cas，synchronized只锁首结点，只要不发生哈希冲突，就不会并发。

2. hashtable一直使用全表锁。



## JVM



### JVM内存模型

JVM需要使用计算机的内存，Java程序所处理的对象或者算法都会使用JVM的内存空间，JVM将内存化为5个区域，这样的结构称之为java内存模型

JMM决定一个线程对共享变量的写入何时对另一个线程可见，JMM定义了线程和主内存之间的抽象关系

https://blog.csdn.net/manba_yqq/article/details/117002937

### JVM内存区域？

程序计数器：在多线程的情况下，程序计数器用于记录当前线程执行的位置。是线程私有的

虚拟机栈：存有方法，局部变量表，对象引用等。是线程私有的。

本地方法栈：存放native方法。是线程私有的

堆：存放对象实例，字符串常量池。hotspot虚拟机中，细分为eden区from survivor区to survivor区（8:1:1），老年区，元空间。是线程共有的。

方法区（具体实现元空间（1.8之前是永久代））：存放类信息，运行时常量池，静态变量等。是线程共有的。类加载等全局数据信息

### jvm参数？

1. xxs：设置虚拟栈的内存大小
2. -Xx:new Ratio:设置老年代和新生代的比例
3. -Xx:Survivor Ratio:设置伊甸区和生存区的比例

### java对象创建过程？

类加载检查：当new时，首先检查类是否被加载过，解析和初始化过，若没有，必须先进行类加载。

分配内存：完成类加载检查后，虚拟机会为其分配内存，具体分配方式由虚拟机的垃圾回收机制决定。比如指针碰撞方式适用于规整的对					内存，空闲列表方法适合不规整的有内存碎片的内存。

初始化零值：虚拟机将对象分配到的空间全部初始化为0值

设置对象头：

执行init方法：

### 虚拟机中对象的布局？

对象头：存放对象的类信息，hashcode，gc分代年龄，锁信息等

实例数据：对象存储的信息

对齐填充：当对象实例数据没有对齐时，需要对齐填充部分

### 什么样的对象进入老年区？

1. 大对象，比如字符串，数组等
2. 动态对象年龄判断之后的大龄对象进入老年区

### 动态对象年龄判断？

hotspot遍历对象时，按照年龄从小到大累计，当某个年龄超过生存区的50%时，更新晋升年龄阈值，超过这个新阈值的对象进入老年区

### 判断堆内数据是否要删除

GCROOT：

栈，本地方法栈，方法区，这些要用的肯定不能删

同时GCroot引用的，或者它引用的引用一般也是不能删

删除的对象一般卫孤立无援的状态

### 堆删除的思路

标记清理：把要清理的对象进行标记，然后清理。但是容易产生碎片。

标记整理：再清理后，后面的对象前移，但是代价太大

复制算法：创建1 2 区，将需要删除的部分打标记，然后复制没有打标记的到2区，整个删除1区，这样开销很大，需要两倍的内存

实际的清理思路：

将堆区进行划分，young区，old区

对young区划分伊甸区，还有两个surivie区，s0,s1    old区只有一块

new对象在伊甸区出生，当E区快满的时候触发GC，出发标记复制，将没有标记复制到两个s区中的一个（两个s区交替工作）

将s0与s1交替使用，提高利用率

每次young区的对象存活一次就+1，到6的时候就直接放入old区

同时old区会存一些大对象

old区如果快满了，会full gc 整个java程序会暂定，全力清理，一般用标记整理/标记清理

![image-20220418020512552](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220418020512552.png)

### Hotspot进行gc的分类？

minor gc：只对新生代进行垃圾回收

major gc：只对老年代进行垃圾回收

mixed gc：对新生代和老年代进行垃圾回收

full gc：对堆和方法区进行垃圾回收（当jvm内存不够时发生）

### 空间分配担保？

在minor gc之前，确保老年区有存放新生代所有对象的空间，如果不大于，会查看是否允许担保失败，如果允许，就minor gc，不允许就full gc

### 如何判断对象已经死亡？

引用计数法：当计数器为0时，证明对象已经死亡，但是无法解决循环引用问题。

可达性分析：假如对象没有到gc root对象的引用链的话，这个对象就已经死亡（虚拟机中引用的对象，本地方法栈中引用的对象，方法区中静态属性和常量引用的对象）

### 类什么时候回收？

没有任何引用指向class对象时

### 强引用？软引用？

强引用：无论如何都不会回收，宁愿报错。

软引用：内存不足时，会回收软引用的对象。

### 软引用和弱引用区别？

软引用是内存不足时会回收，弱引用是不管内存足不足，只要扫描到了就回收

### 垃圾回收算法？

标记-清除法：遍历一遍对象，标记出不需要清除的对象，然后回收所有没被标记的对象。会产生内存碎片。（老年代常用）

标记-复制法：将内存分为两块，当其中一块用完之后，标记出不需要清除的对象，然后将其全部复制到空内存中，最后将所有没被标记						的对象清除。（新生代常用）

标记-整理法：遍历对象，标记出不需要清理的对象，将被标记的对象排在内存前面，清理所有没被标记的对象（老年代常用）

分代回收：hotspot

### 垃圾收集器？

1. 新生代垃圾回收器：serial

2. 老年代垃圾回收器：cms

3. 同时在新生代和老年代：g1

   ![image-20220418130212117](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220418130212117.png)

### cms垃圾回收器回收过程？

1. 初试标记：标记gc root关联的对象，需要暂停其他线程
2. 并发标记：标记gc root关联的对象，不需要暂停线程
3. 重新标记：重新标记并暂停其他线程
4. 并发清除：清除死亡的对象

### g1垃圾回收器？

![image-20220418131643820](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220418131643820.png)



![image-20220418131921593](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220418131921593.png)维护一个优先级列表，依赖标记整理法

### 类加载过程？

加载-验证-解析-初始化（执行clinit方法）

### 双亲委派？好处是？

classloader在加载.class文件时，自底向上检查类是否被加载，自顶向下加载类。

启动类加载器

扩展类加载器

app类加载器

自定义类加载器

双亲委派机制可以防止重复加载类，也可以保证核心类不被修改。

### 如何打破双亲委派机制？

重写一个类继承classloader，重写loadclass方法（tomcat）

### jvm线上故障排查？

cpu飙高

1. 找到cpu消耗最高的进程，记住进程id
2. 找到cpu消耗最高的线程，记住线程id
3. 从堆栈信息里找到对应的线程堆栈

内存问题

1. 内存溢出时输出dump文件，排查问题

2. gc不健康

   

## 并发



### 进程和线程区别？

1. 进程是操作系统资源分配的基本单位，线程是处理器任务调度执行的基本单位。
2. 每个进程都有独立的空间，程序之间切换开销较大，线程可以共享数据，线程之间切换开销小
3. 进程崩溃不会影响其他进程，线程崩溃会影响其他线程
3. 线程是程序执行的最小单位，而进程是操作系统分配资源的最小单位；

### 产生死锁的原因？

死锁：两个或者两个以上的进程争夺资源，而造成的互斥等待现象，就会产生死锁。

1. 互斥条件：该资源的一个时刻只能由一个线程占用
1. 请求和保持：一个线程因请求资源而阻塞时，对以获得的资源保持不放
1. 不剥削条件：线程以获得资源在未使用完情况下，不能被其他线程剥夺，只有使用完才能释放
1. 循环等待：

### 如何预防和避免线程死锁？

破坏占有且等待条件：一次性申请所有资源

破坏不可剥夺条件：占用部分资源的线程进一步申请其他资源时，如果申请不到可以主动释放它占的资源

破坏循环等待条件：按顺序请求资源

### 线程的生命周期

![img](https://img2018.cnblogs.com/blog/1223046/201907/1223046-20190722214114154-276488899.png)

### sleep（）和wait（）区别？

1. sleep（）没有释放锁，wait（）释放锁
2. sleep（）之后，线程会自动苏醒，wait（）之后，需要其他线程调用同一个对象的notify（）
3. sleep（）属于thread类，wait（）属于object类

### java怎么创建线程？

1. 继承thread类
2. 实现runnable接口
3. 实现callable接口
4. 线程池：executors（不推荐使用，对线程控制力比较低，可定义的参数少），threadpoolexecutors（推荐使用，可以自定义参数）

### threadlocal是什么？用它会带来什么问题？

threadlocal是java线程本地存储机制，叫做线程变量，

意思是threadlocal填充的变量是当前线程，该变量对其他线程而言是隔离的，也就是说该变量是当前线程独有的变量。ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量。

一句话理解ThreadLocal，向ThreadLocal里面存东西就是向它里面的Map存东西的，然后ThreadLocal把这个Map挂到当前的线程底下，这样Map就只属于这个线程了。



1. threadlocal可以存储线程私有的数据
2. 底层是threadlocalmap

可能会带来内存泄漏问题，因为threadlocalmap的key是弱引用，而value是强引用，因此垃圾回收的时候，key被回收但是value没被回收。

下一次threadlocalmap调用set（），get（），remove（）的时候会清除value值。

### ThreadLocal与Synchronized的区别

ThreadLocal<T>其实是与线程绑定的一个变量。ThreadLocal和Synchonized都用于解决多线程并发访问。

但是ThreadLocal与synchronized有本质的区别：

1、Synchronized用于线程间的数据共享，而ThreadLocal则用于线程间的数据隔离。

2、Synchronized是利用锁的机制，使变量或代码块在某一时该只能被一个线程访问。而ThreadLocal为每一个线程都提供了变量的副本

，使得每个线程在某一时间访问到的并不是同一个对象，这样就隔离了多个线程对数据的数据共享。

而Synchronized却正好相反，它用于在多个线程间通信时能够获得数据共享。

一句话理解ThreadLocal，向ThreadLocal里面存东西就是向它里面的Map存东西的，然后ThreadLocal把这个Map挂到当前的线程底下，这样Map就只属于这个线程了。


### threadlocal应用场景？

1. 数据库连接管理
2. session管理

### 为什么要用线程池？

降低资源消耗：

提高响应速度：

提高线程的可管理性：

### 为什么推荐用threadpoolexecuter而不用executor？

1. 允许请求队列长度为integer.max_value，容易oom（内存溢出）
2. 允许创建线程数为integer.max_value，容易oom
3. 可以自定义参数

### 线程池7个参数？

1. 核心线程数
2. 最大线程数
3. 最大空闲时间
4. 空闲时间的单位
5. 阻塞队列：arrayblockingqueue，linkedblockingqueue，prirotyblockingqueue
6. 线程工厂
7. 拒绝策略：默认为abortpolicy，拒绝新任务并抛出异常，discardpolicy，直接丢弃新任务，discardoldestpolicy，丢弃最早的未处理任务

### 线程池流程？

![img](data:image/png;base64,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)

### 线程池状态：

1. running：正常接受任务
2. shutdown：不接受新任务，但是内部会处理包括阻塞队列的任务
3. stop：不接受新任务，内部任务全部停止
4. tidying：代表线程池即将终止
5. terminated：代表线程池终止

### 常见的线程池？

fixedthreadpool：固定线程数，使用无界队列，容易oom

singlethreadpool：只有一个线程，使用无界队列，容易oom

cachedthreadpool：允许创建大量线程，容易oom

scheduledthreadpool：定期执行任务

### 线程池大小怎么确定？

cpu密集型任务：n+1，防止缺页中断导致cpu空闲

i/o密集型任务：2n，线程在处理i/o时不会占用cpu，因此可以多配置线程

### 讲讲synchronized四种状态？

1. 无锁：
2. 偏向锁：
3. 轻量锁：
4. 重量锁：

### synchronized底层原理？

同步代码是用monitorenter和monitorexit实现的，任何java对象都有一个monitor，本质都是对monitor的获取

# synchronized关键字的底层原理

通过对.class文件反编译可以发现：

- 同步方法通过`ACC_SYNCHRONIZED`修饰。
- 代码块同步使用`monitorenter`和`monitorexit`两个指令实现。

虽然两者实现细节不同，但其实本质上都是JVM基于**进入和退出Monitor对象**来实现同步，JVM的要求如下：

- `monitorenter`指令会在编译后插入到同步代码块的开始位置，而`monitorexit`则会插入到方法结束和异常处。
- 每个对象都有一个`monitor`与之关联，且当一个`monitor`被持有之后，他会处于锁定状态。
- 线程执行到`monitorenter`时，会尝试获取对象对应`monitor`的所有权。
- 在获取锁时，如果对象没被锁定，或者当前线程已经拥有了该对象的锁（可重进入，不会锁死自己），将锁计数器加一，执行`monitorexit`时，锁计数器减一，计数为零则锁释放。
- 获取对象锁失败，**则当前线程陷入阻塞**，直到对象锁被另外一个线程释放。

### volatile底层原理？

加入volatile时，会出现一个lock前缀指令，相当于一个内存屏障

1. 确保指令重排时不会把后面的指令拍到前面
2. 强制将对缓存的修改操作写入主存

### synchronized锁升级过程？

1. 偏向锁升级为轻量级锁：线程1占据资源，当线程2来抢资源时，首先会检查线程1是否存活，否，变无锁，是，查看线程1是否还需要这个资源，是，升级为轻量级锁，否，变成无锁
2. 轻量级锁升级为重量级锁：线程1复制对象头的同时，线程2准备获取锁，复制了对象头，在cas自旋等待，这时又有线程3来竞争资源，轻量级锁会升级为重量级锁，将除了线程1之外所有的线程阻塞

### synchronized和volatile的区别？

1. volatile只能用来修饰变量所以没有原子性，synchronized可以修饰方法和代码块。
2. volatile不能保证原子性，能保证可见性（对属性修改时，直接将cpu的数据写回内存，读取变量直接从内存中读），但是synchronized都能保证

### synchronized和lock区别？

1. synchronized依赖jvm，lock是个接口
2. synchronized无法判断是否获取到锁，lock可以
3. synchronized可以自动释放锁，lock需要unlock（）手动解锁，要不然会造成死锁
4. synchronized可重入，不可中断，不公平，lock可重入，可中断，公平

### synchronized和reentrantlock区别？

1. synchronized依赖jvm，reentrantlock是个实现了lock接口的类
2. synchronized可以自动释放锁，reentrantlock需要手动解锁，需要在finally里进行解锁
3. 都是可重入锁
4. reentrantlock默认非公平锁，可实现公平锁
5. synchronized 是不可中断的，reentrantlock可以通过trylock的方法进行

### 悲观锁与乐观锁

悲观锁：实质性的锁，获取mointer 具有互斥

乐观锁：设置个状态，其他线程通过这个状态是否被使用。比个版本号

### aqs是什么？

队列同步器

### execute（）方法和submit（）方法的区别？

execute（）方法用于提交不需要返回值的任务，无法判断任务是否被线程池成功执行

submit（）方法用于提交需要返回值的任务，可以判断任务被线程池是否成功执行



# Redis



### redis优缺点？

优点：

- **读写性能好**，读的速度可达110000次/s，写的速度可达81000次/s。 
- **支持数据持久化**，有AOF和RDB两中持久化方式 
- **数据结构丰富**，支持String、List、Set、Hash等结构 
- **支持事务**，Redis所有的操作都是原子性的
- **支持主从复制**，主机可以自动将数据同步到从机，进行读写分离。 

缺点：

- 因为Redis是将数据存到内存中的，所以会受到内存大小的限制，不能用作海量数据的读写 

- Redis不具备自动容错和恢复功能

  ![](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220419010600489.png)

![image-20220419010621159](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220419010621159.png)

### redis为什么这么快？

运行在内存中

数据结构简单

使用io多路复用技术

单线程实现

### redis 6.0为什么引用了多线程？

redis瓶颈在网络和内存，引入多线程是为了解决网路io读写这个瓶颈，执行命令还是单线程的

### redis的数据类型？

string：计数（底层是sds，java中string是final char）

list：评论列表（底层是双向链表）

set：共同好友（底层是无序集合）

zset：获取排名前几的用户（底层是有序集合，散列表和跳表实现，去重，多了score变量）

hash：存储对象（底层是无序散列表，类似于jdk1.8之前的hashmap）

### zset怎么实现的？

1. ziplist：元素少于128的时候
   ziplist header + 保存的数据 + 数据的score
2. skiplist：跳跃表本质是空间换时间的策略，是可以进行二分查找的有序链表，在原链表上添加了多级索引。
   散列表+跳跃表
   根据score从小到大排序

### redis跳跃表和普通跳跃表有什么不一样？

1. redis跳跃表key允许重复，普通跳跃表不允许

2. 最底层的链表不是单向的，是双向的

3. redis的跳跃表可以很快计算每个元素的排名

### redis为什么用跳跃表不用红黑树？

内存占用少

查询性能不比红黑树差

简单实现更容易维护

### 键的过期删除策略？

惰性删除：只有访问到这个键之后才看他有没有过期，如果过期就删除，这种方法可以节约cpu资源，但是会消耗大量内存

定时删除：为每个设置过期的键设置定时器，时间到了就删除。这种方法可以立即删除过期的键，但是会消耗大量cpu资源。

定期删除：每隔一段时间检查一些键，删除其中过期的键。是惰性删除和定时删除的折中

### redis的内存淘汰机制？

volatile-lru：从设置过期时间的键中使用lru算法删除最少使用的键

volatile-ttl：从设置过期时间的键中删除即将过期的键

volatile-random：从设置过期时间的键中随机删除键

volatile-lfu：从设置过期时间的键中删除最近不常用的键

allkeys-lru：从所有的键中用lru算法删除键

allkeys-random：从所有的键中随机删除键

allkeys-lfu：从所有的键中用lfu删除键

noeviction：禁止写入操作

### redis持久化机制有哪些？有什么优缺点？

rdb：redis默认的持久化机制，按照一定的时间间隔将数据以快照的形式存入硬盘，恢复时是将快照读取到内存里。

![图片说明](https://uploadfiles.nowcoder.com/images/20220115/115285789_1642240430608/5D041BCCBC813567019DC1860B0148AD)

优点：

1. 适合大规模的数据恢复
2. 比aof启动效率高

缺点：

1. 数据安全性低，在一定的时间间隔进行备份，如果redis突然死机，会丢失最近一次的快照
2. 他是依靠fork子进程来完成备份的，如果数据集过大，会导致服务器停顿一段时间



aof：以日志形式记录服务器的每一个写，删除操作，查询操作不会被记录，以文本的方式来记录。

![图片说明](https://uploadfiles.nowcoder.com/images/20220115/115285789_1642240446939/0685AB2C1304254775298E5617F0D01C)

优点：

1. 具有更高的安全性，redis提供三种策略，每秒同步，每修改同步和不同步。如果redis突然死机，丢失的数据会比rdb少很多。
2. 在写入日志时所采用的是append（）操作，就算redis突然死机，也不会影响已经写入的日志。

缺点：

1. aof占用的空间比rdb要大
2. 重建速率低于rdb
3. aof机制效率要低于rdb

### aof过大咋办？

重写：内容压缩，将重复的命令合并

### 缓存穿透是什么？怎么解决？

当大量请求的key不存在于redis时，这些请求命令会落到数据库上。

缓存无效key：假如请求的key都不存在于redis和数据库中时，将该key写到redis中并设置过期时间，最好设置短时间。

布隆过滤器：把所有可能存在请求的key放入布隆过滤器中，当用户请求时，先看在不在布隆过滤器里，不在的话直接返回错误信息，在						的话走正常流程。

### 布隆过滤器是什么？

将所有的可能存在的数据多次哈希到一个足够大的bitmap中，一个一定不存在的数据会被bitmap拦截掉

所以布隆过滤器判断元素在其中时，可能会出现误判，因为不同元素的hash可能会相同，但是布隆过滤器说元素不存在那就是真的不存在

### 缓存雪崩？怎么解决？

是指在设置缓存过期时间时用了相同的时间，缓存在同一时间突然大面积消失，请求命令全部落在数据库上，导致数据库死机

解决方案：

事前：采用redis集群，避免单机出现问题导致整个缓存服务无法启用，限流加锁，避免同时处理大量请求，设置随机过期时间

事中：缓存降级（熔断，降级，限流）

事后：redis备份和恢复，快速缓存预热

### redis和数据库一致性怎么保持？

旁路缓存模式：

写：先更新数据库，然后直接删除缓存

读：先从缓存中读取，如果没有就从数据库读，然后更新缓存

缺点：

1. 首次请求的数据不一定在缓存中（将热点数据写入到缓存中）
2. 写操作频繁会导致数据被删除频繁，影响缓存命中率（更新数据库时更新缓存，需要加一个锁来保证不出现线程安全问题）

### redis怎么实现分布式锁？

1. setnx + expire（获取锁+设置过期时间）
2. lua脚本（原子性）

3. redission：

   线程去获取锁，若获取成功，执行lua脚本（根据hash算法选择一个master节点），保存到redis中

   线程去获取锁，若获取失败，一直自旋获取锁，获取成功后，执行lua脚本（根据hash算法选择一个master节点），保存到redis中

   看门狗机制：若线程还要占有锁的话，自动延长锁的时间

   

4. redlock：
   按顺序向n个master请求加锁
   若连接超出超时时间，跳过该master
   如果有n/2 + 1个master加锁成功，并且所用时间小于过期时间，加锁成功
   若都不行就失败

### redis分布式锁的缺点？

在哨兵模式下，客户端1对master节点写入了redission锁，此时会复制给slave节点，此时master死机，slave节点变成master节点，客户端2在新的master上也能加锁，因此这会导致脏数据的产生。

### redis集群？

1. 主从模式
   1. master可以读写，slave只读
   2. master的数据会同步给slave
   3. master一对多slave，slave一对一master
   4. master挂了不影响slave的读，重启后master恢复读写操作
   5. slave挂了不影响其他数据库，重启后从master同步数据
2. 哨兵模式
   1. master挂了之后，会在slave中选一个为新的master，master重启后会变成slave
3. cluster模式

### 主从同步方法？

1. 第一次同步是全量复制
2. 增量复制

# MySQL



### acid特性？

原子性：事务是最小的执行单位，要么全部完成，要么全部不完成（undolog保持原子性）

一致性：事务执行前后，数据保持一致

隔离型：并发访问数据库时，一个用户的事务不被其他事务干扰（mvcc + next-key lock保持隔离型）（上锁）

持久性：事务被提交后，他对数据库的影响是永久的（redolog保持持久性）

`redo log` 它是物理日志，记录内容是“在某个数据页上做了什么修改”

### 并发事务带来的问题？（隔离性）

脏读：事务1正在修改数据但没提交时，事务2访问数据库读到了这个数据。

丢失修改：事务1在读取一个数据时，事务2也在读取，事务1做出了修改，事务2在之后也做出了修改。

不可重复读：事务1多次读取同一数据时，事务2在其中修改了数据导致事务1两次读到的数据不一样

幻读：事务1在读取的时候，事务2又添加了新数据，事务1发现了一些原本不存在的数据

### 事务的隔离级别？

读取未提交（行锁）：导致脏读，不可重复读，幻读

读取提交（行锁）：导致不可重复读，幻读

可重复读（n （默认隔离级别）：导致幻读

可串行化（next-key lock）：最高隔离级别

**InnoDB 存储引擎的锁的算法有三种：**

- Record lock：记录锁，单个行记录上的锁
- Gap lock：间隙锁，锁定一个范围，不包括记录本身
- Next-key lock：record+gap 临键锁，锁定一个范围，包含记录本身

### 索引的作用？

没有索引的话，会多次读取硬盘，加入索引的话，一般只需读取2-4次硬盘（因为b+树一般高度为2-4层）

### 什么情况下需要建立索引？

经常用于查询的字段，在where条件中的

多表关联查询时的作为关联条件的列

重复度低的列

### innodb常见的索引原理？

1. b+树
2. hash
3. 全文索引

### 为什么不用hash表？为什么不用红黑树？

1. 有可能出现hash冲突
2. hash表不支持顺序和范围查找，hash会依次查找，io操作次数太多
3. hash不支持模糊查找（like）
4. b+支持联合索引最左侧原则，hash不支持
5. 红黑树io操作次数太多，并且大量数据下会有右倾风险

### B树的目的

弥补存储之间的访问速度的差异，实现高效I/O

通过降低深度-》提高速度

`但是当数据量非常大，树的存储的元素数量是有限的，这样会导致二叉查找树结构由于树的深度过大而造成磁盘I/O读写过于频繁，进而导致查询效率低下。另外数据量过大会导致内存空间不够容纳平衡二叉树所有结点的情况`。

### B树和B+树的区别？

有k棵子树的非叶子节点有k个（b+)树，k-1(b树)

1. b树的所有节点既存放key也存放数据，b+树只有叶子结点放key和数据，其他节点只放key

2. b树的叶子结点是独立的，b+树的叶子结点有指向下一个叶子结点的引用

3. b树的检索相当于2分查找，b+树是从根节点到叶子结点，叶子结点之间的二分查找。


### 为什么用b+树不用b树？

1. b树范围查询效率低于b+树，
2. b+树可以存储大量索引，而b树节点存储数据，占用空间太大，
2. b树每个节点存储分支太少
2. b+树io操作少
3. 查询效率稳定（log（n）），因为每次查询都是从根节点查到叶子结点，路径相同

### 二级索引？

二级索引的叶子结点存储的是主键

唯一索引：目的是为了防止数据重复插入

普通索引：

前缀索引：只适用于字符串类型的数据

组合索引：表中多个字段组合上创建的索引，遵循最左匹配原则

### 聚集索引与非聚集索引？必考

聚集索引是将索引和数据放在一起，也就是叶子结点为具体数据。主键索引属于聚集索引（innodb引擎就是聚集索引）

优点：

查询速度快，定位到索引的结点就相当于定位到了数据

缺点：

更新代价大，更新数据就要跟新索引，所以主键是不可被修改的



非聚集索引是将索引和数据放在不同的位置，二级索引就是非聚集索引（myisam引擎就是非聚集索引）

优点：

更新代价比聚集索引小

缺点：

可能会二次查询（回表）

### 非聚集索引一定会回表吗？

不一定，覆盖索引，即需要查询的字段恰好是索引的字段，直接根据索引就能查到数据了，就不用回表

### 索引的设计原则？

1. 索引列的区分度越高越好，比如性别这种的索引效果就很差

2. 尽量使用短索引，对较长的字符串应该指定较短的前缀。

3. 利用最左匹配原则


### 索引失效的情况？必考

1. 负向查询，比如not in / ！=等
2. 搜索条件带or，除非or条件中的每个列都有索引
3. 对于组合索引，不使用最左侧的部分，就不会使用索引
4. like查询以%开头的索引会失效
5. 字符串类型不加引号
6. 在索引列上做计算，函数

### innodb和myisam区别？

innodb：

1. 支持事务
2. 支持崩溃恢复能力，依赖于redo log(保证持久性)，undo log（保证原子性）
3. 支持行级锁（只有在索引上是行锁，剩下也是表锁）（保证隔离性）
4. 支持外键
5. 支持mvcc（保证隔离性）
6. 不保存表的行数



myisam：

1. 不支持事物
2. 不支持行级锁，只有表级锁
3. 不支持崩溃恢复
4. 不支持外键
5. 不支持mvcc
6. 保存表的行数

### mvcc原理？（背）

mvcc就是同一份数据保留多版本的一种方式，只在读取提交和可重复读两个隔离级别下工作，依赖undo log 和 read view

mvcc在数据库每行数据后面加了三个隐藏字段

1. 当前事务id：

2. 回滚指针：指向上一个版本

3. row_id：如果没有主键或者唯一索引时，会创建这个字段，否则不创建

使用事务更新数据的流程：

1. 用排他锁锁住

2. 将该行原本的值拷贝到undo log，作为旧版本用于回滚

3. 更新当前的值，更新事务id，回滚指针指向上一个版本

   

read view用来做可见性判断，保寸了不应该让这个事务看到的其他事务id

读取提交隔离级别：每次select前都会生成一个read view

可重复读隔离级别：第一次select前生成一个read view

### innodb常见的锁算法？

共享锁

行锁（排他锁）：

​			record lock：单行记录上锁

​			gap lock：间隙锁，锁定一个范围，不包括记录本身

​			next-key lock：record + gap lock，锁定一个范围，包括记录本身

意向锁

### innodb怎么解决幻读？

mvcc + next-key lock

1. 执行快照读时，会以mvcc快照读的方式读取数据
2. 执行当前读时，会读取最新数据，next-key lock会锁定他们的间隙，防止其他事务在查询范围内插入数据（for update/lock in share mode）

### 乐观锁和悲观锁？

悲观锁：总是假设最坏情况，每次读取数据的时候默认其他线程会更改数据，因此需要进行加锁，当其他线程想要访问数据时，都需要阻				塞挂起。

​				共享锁：多个事物对同一数据共享一把锁，只能读不能修改

​				排他锁：如果一个事物获取了一个数据行的排他锁，其他事务就不能获取改行的锁，既可以读取也可以修改

乐观锁：假设好情况，在数据进行提交更新的时候，判断现有的数据是否和原数据一致，如果没有被其他线程修改则进行更新，不需要数				据库的锁机制				

​				cas：compare oldvalue，如果相等就swap newvalue，如果不相等，就自旋

​				线程安全问题，多条线程同时占用资源，compare和swap必须只有一个线程操作，所以cas必须是原子性的

### mysql中innodb悲观锁的实现？乐观锁的实现？

悲观锁：

1. for update：加排他锁
2. lock in share mode：加共享锁（容易死锁）

乐观锁：

​		加版本号

### 数据库怎么解决死锁？

1. 超时回滚
2. 采用死锁检测机制（wait-for graph等待图）

### 数据库日志？

1. binlog
   记录对Mysql数据库执行修改的所有操作，不会记录select，主要用于主从复制和数据恢复
2. redo log
   记录的是要更新的数据，修改数据并不会立即同步到磁盘，而是先记录到redo log中，等待合适的时机再刷盘。
3. undo log
   它保留了记录修改前的内容，通过undo log可以实现事务回滚

### 优化数据库的方法？

1. sql优化

   1. 用join代替子查询
   2. 使用索引，避免索引失效
   3. 优化表结构
   4. 使用not null

2. 业务逻辑优化

3. 硬件性能优化

4. 读写分离

   master写，slave读（代理或者组件来完成）
   主从复制依赖binlog

5. 分库分表

# 计网

### tcp/ip协议？

1. 应用层（http，smtp，dns）
2. 传输层（tcp，udp）
3. 网络层（ip）
4. 网络接口层（mac）

### https和http区别？

1. http端口为80，https为443
3. http传输内容都为明文，https是运行在ssl/tls的http协议，所有传输采用了对称加密，加密的密钥采用了非对称加密。

### https原理？

1. 客户端告知服务端相关参数，协商加密算法
2. 服务端告诉选中的加密算法
3. 服务端发送ca证书
4. 客户端使用公钥对证书验证
5. 客户端和服务端产生对称密钥
6. 传输数据

### http请求报文都有什么？（？？）

1. 请求行：请求方法get或post，请求url，http版本及协议
2. 请求头：accept，referer，connection：keep-alive，cookie
3. 请求体：用户请求数据，如账号密码等

### http响应报文都有什么？（？？？？）

1. 响应行：http协议及版本，状态码
2. 响应头：sever，date
3. 响应体：html等

### http1.0和http1.1区别？

1. http1.1中加入了大量状态码，比如100（在请求大资源前的预热请求）
2. http1.1的缓存机制也进行了扩展
3. http1.0默认短连接，http1.1默认为长连接
4. http1.1在请求头中加入了host字段
6. http1.1优化了带宽，在请求头中加入了range头域，可以指定获取资源的某个部分

### get和post区别？

1. get请求参数在url中（携带数据量取决于对url长度的限制），post请求参数在请求体中（携带数据量理论上没有限制）
2. get将请求头和请求体一起发出去，post先发送请求头，服务器响应100后，再发送请求体
3. get请求参数会被浏览器存到记录里，post不会

### 在浏览器输入url地址到显示页面的过程？

1. 浏览器通过dns协议查找网站对应的ip地址
2. 建立tcp连接
3. 浏览器向服务器发送一个http请求（cookies也会被发给浏览器）
4. 服务器处理请求并返回html
5. 浏览器解析页面并显示

### 常见状态码？

1xx：信息型状态码

2xx：成功状态码（200成功）

**3xx：重定向状态码（301永久重定向，302临时重定向）**

**4xx：客户端错误状态码（404服务器无法找到请求的资源）**

**5xx：服务端错误状态码（500服务器发生了错误）**

### dns解析过程？

1. 户机提出域名解析请求,并将该请求发送给本地的[域名服务器](https://baike.baidu.com/item/域名服务器/9705133).

2. 当本地的域名服务器收到请求后,就先查询本地的缓存,如果有该纪录项,则本地的域名服务器就直接把查询的结果返回.

3. 如果本地的缓存中没有该纪录,则本地域名服务器就直接把请求发给[根域名服务器](https://baike.baidu.com/item/根域名服务器/5907519),然后根域名服务器再返回给本地域名服务器一个所查询域(根的子域)的主域名服务器的地址.

4. 本地服务器再向上一步返回的域名服务器发送请求,然后接受请求的服务器查询自己的缓存,如果没有该纪录,则返回相关的下级的域名服务器的地址.

   第五步：重复第四步,直到找到正确的纪录.

   第六步：本地域名服务器把返回的结果保存到缓存,以备下一次使用,同时还将结果返回给客户机.

   让我们举一个例子来详细说明解析域名的过程.假设我们的客户机如果想要访问站点：www.linejet.com此客户本地的域名服务器是dns.company.com , 一个根域名服务器是NS.INTER.NET , 所要访问的网站的域名服务器是dns.linejet.com,域名解析的过程如下所示.

   (1)客户机发出请求解析域名www.linejet.com的报文

   (2)本地的域名服务器收到请求后, 查询本地缓存, 假设没有该纪录, 则本地域名服务器dns.company.com则向根域名服务器NS.INTER.NET发出请求解析域名www.linejet.com

   (3)根域名服务器NS.INTER.NET收到请求后查询本地记录得到如下结果:linejet.com NS dns.linejet.com （表示linejet.com域中的域名服务器为：dns.linejet.com ）, 同时给出dns.linejet.com的地址,并将结果返回给域名服务器dns.company.com

   (4)域名服务器dns.company.com 收到回应后,再发出请求解析域名www.linejet.com的报文.

   (5)域名服务器 dns.linejet.com收到请求后,开始查询本地的记录，找到如下一条记录:www.linejet.com A 211.120.3.12 （表示linejet.com域中域名服务器dns.linejet.com的IP地址为:211.120.3.12）,并将结果返回给客户本地域名服务器dns.company.com

   (6)客户本地域名服务器将返回的结果保存到本地缓存,同时将结果返回给客户机.

   这样就完成了一次域名解析过程.

### cookie和session的区别？

cookie保存在客户端，session保存在服务端

### 用户登录系统的过程？

1. 用户向服务器发送用户名，密码等
2. 服务器验证通过后，为用户创建了一个session
3. 服务器向用户返回一个sessionID，写入用户的cookie
4. 当用户保持登录时，cookie与请求会被发送出去
5. 服务器将cookie中的sessionid与session对比，验证用户身份

### tcp三次握手过程？

1. 客户端向服务端发送带有syn的数据包
2. 服务端向客户端发送带有syn和ack的数据包
3. 客户端向服务端发送带有ack的数据包

### 两次握手为什么不行？

三次挥手主要为了防止已失效的连接请求报文段突然又传到了服务器：

1. 比如客户端发出连接请求，可能因为网络阻塞原因，没有及时发送到服务器，所以客户端重传一次
2. 连接成功，数据传输完毕后释放了连接
3. 此时客户端发送的第一个请求刚到达服务器，于是服务器误认为又发送了新的请求，向客户端建立连接，但是客户端不会响应，所以造成了资源的浪费

### tcp四次挥手过程？

1. 客户端向服务端发送fin，用来关闭连接
2. 服务端向客户端发送ack，表示收到关闭连接的请求
3. 服务端向客户端发送fin，用来关闭连接
4. 客户端向服务端发送ack，表示收到关闭连接的请求

### 为什么不能三次挥手？

因为服务端在关闭连接之前要将数据传回客户端，需要一个时间间隙

### 第四次挥手为什么等待2msl？

1. 保证客户端发送的最后一个ack能到达服务器
2. 防止已失效的请求出现在本连接中

### tcp，udp的区别？

1. tcp面向连接，udp无连接
2. tcp传输可靠，udp传输不可靠
4. tcp需要的资源多，udp需要的资源少
5. tcp首部字节多，udp首部字节少
5. tcp只能一对一，udp可以一对一，一对多，多对一，多对多

### tcp怎么保证传输可靠？

1. 校验和：假如tcp首部和数据的校验和有问题，就会丢弃这个数据
2. 流量控制：tcp利用滑动窗口来实现流量控制
3. 拥塞控制：网络拥塞时，减少数据的发送，慢开始，快重传，快恢复
4. arq协议：停止等待arq协议，连续arq协议维护一个发送窗口
5. 超时重传：发出一个报文段后，启动计时器，如果没在规定的时间内收到确认就重新传送



# 操作系统



### 进程间通信的方法？

1. 匿名管道
2. 有名管道
3. 消息队列
4. 共享内存：需要互斥锁或信号量
5. 套接字：客户端和服务端之间

### java线程间通信的方法？

1. volatile
2. wait / notify方法
3. join方法
4. threadloacl

### 线程间同步的方法？

1. 互斥量
2. 信号量
3. 事件

### 进程的调度算法？

1. 先到先服务：队列
2. 短作业优先：选择一个预估时间最短的作业
3. 时间片轮转：每个进程被分配一个时间段，即该进程运行的时间
4. 多级反馈队列：
5. 优先级调度：



# 海量数据处理



### 方法总结

1. 分而治之/hash映射 + hashmap + 堆/快速/归并排序
2. 多层桶
3. 1-bitmap / 2-bitmap
4. 字典树



# Spring



### ioc和aop？

IOC是控制反转，IOC给我们提供了一个IOCbean容器，这个容器会帮我们自动去创建对象，不需要我们手动创建，IOC的实现方式为DI（Dependency Injection 依赖注入），依赖注入就是将实例变量传入到一个对象中去，我们可以通过写Java注解代码或者是XML配置方式，把我们想要注入对象所依赖的一些其他的bean，自动的注入进去。



aop是面向切面编程，将例如事务处理，日志管理，权限控制等封装起来，减少重复代码。基于动态代理。

### bean是什么？

被ioc容器管理的对象

### bean作用域？

1. singleton，单例
2. prototype，每次请求都会创建新bean实例
3. request，每次http请求都会创建新bean实例
4. session，每次来自新session的http请求都会产生新bean，仅在当前http session内有效

### 怎么解决单例bean的线程安全问题？

1. 不在bean中定义可变的变量
2. 定义threadlocal，将需要的可变变量存入threadlocal中

### springmvc？

model（模型）-view（视图）- controller（控制器）



service层：处理业务

dao层：数据库操作

entity层：实体类

controller层：控制层，返回数据给页面

### spring中用到了哪些设计模式？

1. 工厂模式（通过beanfactory创建bean对象）
2. 单例模式
   @Scope(value = 'singleton')
3. 代理模式（aop的实现）
4. 观察者模式（spring事件驱动模型）
5. 模版模式（jdbctemplate，redistemplate等对数据库操作的类）
6. 适配器模式（适配controller）

### 常用注解？

1. @SpringBootApplication
2. Bean相关
   1. @Autowired（注入bean）
   2. @Service（业务逻辑层）
   3. @Controller（控制层）
   4. @Repository（数据访问层）
   5. @RestController
   6. @Scope
   7. @Configuration（声明为配置类）
3. http请求
   1. @GetMapping
   2. @PostMapping
4. 前后端传值
   1. @PathVariable
   2. @RequestParam
   3. @RequestBody
5. 读取配置信息
   @Value
6. 参数校验
   1. @NotNull
   2. @NotEmpty
   3. @Valid
7. jpa相关
   1. @Entity
   2. @Table
   3. @Id
   4. @Column

### springboot自动装配？

在pom.xml中注入依赖，r通过注解或者配置就能在springboot的帮助下实现某块功能

# linux常用命令



### 查找文件

find / -name filename.txt

查找目录下的filename.txt文件

### 查看程序是否运行

ps -ef｜grep tomcat

查看有关tomcat的进程

### 终止线程

kill

### 查看文件

ls

### 当前目录

pwd

### 复制文件

cp

### 创建目录

mkdir

### 删除目录

rmdir

### 删除文件

rm -rf

### 移动文件

mv

### 切换用户

su

### 修改文件权限

chmod

### 查看文件前十行

head

### 查看文件后十行

tail

### 处理文本

awk
