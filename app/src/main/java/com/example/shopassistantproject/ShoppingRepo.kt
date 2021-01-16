package com.example.shopassistantproject

class ShoppingRepo(private val firebaseDB1: FirebaseDB) {

    fun getShopping(callback2: CallBackRepo) {
        firebaseDB1.getShopping(object: Callback {
        override fun getLista(shoppingList: List<Shopping>) {
            callback2.getShopCall(shoppingList)
        }
    })}

    fun add(shopping: Shopping) = firebaseDB1.add(shopping)

    fun modify(shopping: Shopping) = firebaseDB1.modify(shopping)

    fun delete(shopping: Shopping) = firebaseDB1.delete(shopping)

    fun removeAll() = firebaseDB1.removeAll()

    fun getItemCount(): Long {
        val fbItemCount = firebaseDB1.fbItemCount
        return fbItemCount
    }
}

interface CallBackRepo {
    fun getShopCall(shoppingList: List<Shopping>)
}