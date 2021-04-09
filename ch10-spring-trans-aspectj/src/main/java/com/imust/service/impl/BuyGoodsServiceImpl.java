package com.imust.service.impl;

import com.imust.dao.GoodsDao;
import com.imust.dao.SaleDao;
import com.imust.domain.Goods;
import com.imust.domain.Sale;
import com.imust.excep.NotEnoughException;
import com.imust.service.BuyGoodsService;

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
