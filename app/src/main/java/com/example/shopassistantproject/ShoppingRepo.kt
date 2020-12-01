package com.example.shopassistantproject

class ShoppingRepo(private val shoppingDao: ShoppingDao) {

    fun getShopping() = shoppingDao.getShopping()

    fun add(shopping: Shopping) = shoppingDao.add(shopping)

    fun modify(shopping: Shopping) = shoppingDao.modify(shopping)

    fun delete(shopping: Shopping) = shoppingDao.delete(shopping)

    fun removeAll() = shoppingDao.removeAll()
}