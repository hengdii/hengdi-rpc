package github.javahengdi.compress;

import github.javahengdi.extension.SPI;

/**
 * @program: hengdi-rpc
 * @description: 压缩
 * @author: Jiaty
 * @create: 2021-03-10 14:53
 **/

@SPI
public interface Compress {

    byte[] compress(byte[] bytes);

    byte[] decomppress(byte[] bytes);
}
