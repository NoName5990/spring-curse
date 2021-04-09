package com.imust.dao;

import com.imust.domain.Goods;

public interface GoodsDao {
    //更新库存
    //goods表示本次用户购买的商品信息，id，购买数量
    int updateGoods(Goods goods);

    //查询商品信息
    Goods selectGoods(Integer id);
}
