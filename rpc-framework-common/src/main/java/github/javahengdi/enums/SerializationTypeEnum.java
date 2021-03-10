package github.javahengdi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: hengdi-rpc
 * @description: 序列化类型
 * @author: Jiaty
 * @create: 2021-03-10 15:32
 **/

@AllArgsConstructor
@Getter
public enum SerializationTypeEnum {

    /**
     * 前言：kryo是个高效的java序列化/反序列化库，目前Twitter、yahoo、Apache、strom等等在使用该技术，比如Apache的spark、hive等大数据领域用的较多。
     *
     * 为什么使用kryo而不是其他？
     * 因为性能足够好。比kyro更高效的序列化库就只有google的protobuf了（而且两者性能很接近）
     * ，protobuf有个缺点就是要传输的每一个类的结构都要生成对应的proto文件
     * （也可以都放在同一个proto文件中，如果考虑到扩展性的话，不建议放在一个proto文件中），
     * 如果某个类发生修改，还得重新生成该类对应的proto文件；
     * 另外考虑到项目中用的全部是java技术栈，不存在不同编程语言间的兼容性问题，因此最终采用了kryo作为序列化库。
     *
     * 使用场景：（数据交换或数据持久化）比如使用kryo把对象序列化成字节数组发送给消息队列或者放到redis等nosql中等等应用场景。
     *
     * 注意：由于kryo不是线程安全的，针对多线程情况下的使用，要对kryo进行一个简单的封装设计，从而可以多线程安全的使用序列化和反序列化
     */
    KYRO((byte) 0x01, "kyro"),

    /**
     * 什么是Protocol Buffer？
     * Protocol Buffer是谷歌出品的一种数据交换格式，独立于语言和平台，类似于json。
     * Google提供了多种语言的实现：java、c++、go和python。
     * 对象序列化城Protocol Buffer之后可读性差，但是相比xml，json，它占用小，速度快。适合做数据存储或 RPC 数据交换格式。
     *
     * 相对我们常用的json来说，Protocol Buffer门槛更高，因为需要编写.proto文件，再把它编译成目标语言，这样使用起来就很麻烦。但是现在有了protostuff之后，就不需要依赖.proto文件了，他可以直接对POJO进行序列化和反序列化，使用起来非常简单。
     */
    PROTOSTUFF((byte) 0x02, "protostuff");

    private final byte code;
    private final String name;

    public static String getName(byte code) {
        for (SerializationTypeEnum c : SerializationTypeEnum.values()){
            if (c.getCode()== code){
                return c.getName();
            }
        }
        return null;
    }

}
