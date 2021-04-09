package com.imust.service.impl;

import com.imust.dao.GoodsDao;
import com.imust.dao.SaleDao;
import com.imust.domain.Goods;
import com.imust.domain.Sale;
import com.imust.excep.NotEnoughException;
import com.imust.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 一个方法中，涉及多个操作，为了保证数据的一致性，我们要用到事务，使这些事务要不都成功，要不都失败，这样数据就不会有部分成功而
 * 导致数据不一致
 *  当然，对于已经写完了的代码依然是可以增加事务的，即与那三个操作有关，spring会自动增加事务（记住重要的三个就行）
 *
 *  给已经存在的方法通过aop增加事务功能
 */
public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;
    /**
     * 设置事务的：
     *      1、事务的传播行为
     *      2、事务的隔离级别
     *      3、是否只读
     *      4、回滚并抛出异常
     *  rollbackFor：表示发生指定的异常一定回滚
     *      1）处理逻辑：spring框架首先会检查方法抛出的异常是不是在rollbackFor的属性值中
     *      2）如果异常在rollbackFor列表中，不管是什么类型的异常，一定回滚
     *          把异常加在rollbackFor列表中，那么这个异常抛出的时候就一定会执行回滚操作
     *      3）如果不在列表中，spring会判断异常是不是RuntimeException，如果是一定会回滚
     *          因此，如果是默认的，那么回滚的情况只有运行是异常才会抛出
     * @Tranctional(...)与直接写的@Tranactional是完全等效的
     * @Tranctional使用的是事务控制的默认值，默认传播行为是REQUIRED，默认隔离级别是DEDAULT，默认抛出异常，回滚事务
     * 注意：
     *  加在public方法上，其他的私有和保护不行
     *  可以加在类上边，表示这个类中的所有公共方法都具有事务，但是意义不大，很多都用不到，因此常规还是加载方法之上
     */
//    @Transactional(
//            propagation = Propagation.REQUIRED,
//            isolation = Isolation.DEFAULT,
//            readOnly = false,
//            rollbackFor = { NullPointerException.class,NotEnoughException.class }
//    )
    @Transactional
    @Override
    public void buy(Integer goodsId, Integer nums) {
        /**
         * 1、记录销售的信息
         * 2、更新库存
         */
        System.out.println("========buy的方法开始了=========");
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);
        //判断
        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods == null) {
            //商品不存在
            throw new NullPointerException("编号是"+goodsId+"商品不存在");
        } else if (goods.getAmount() < nums) {
            throw new NotEnoughException("编号是" + goodsId + "商品库存不足");
        }

        //修改
        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("======buy方法的完成======");
    }


    //给两个类赋值
    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }
}
