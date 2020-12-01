package com.example.shopassistantproject

class ShoppingRepo(private val shoppingDao: ShoppingDao) {

    fun getShopping() = shoppingDao.getShopping()

    fun add(shopping: Shopping) = shoppingDao.add(Shopping)

    fun modify(shopping: Shopping) = shoppingDao.modify(Shopping)

    fun delete(shopping: Shopping) = shoppingDao.delete(Shopping)

    fun deleteAll() = shoppingDao.deleteAll()
}