package com.example.shopassistantproject

class MapsRepo(private val firebaseDB2: FirebaseDBMaps) {

    fun getMaps(callback3: CallBackRepoMaps) {
        firebaseDB2.getMaps(object: CallbackMaps {
            override fun getListaMaps(mapsList: List<Maps>) {
                callback3.getMapsCall(mapsList)
            }
        })}


fun add(maps: Maps) = firebaseDB2.add(maps)

fun delete(maps: Maps) = firebaseDB2.delete(maps)

fun removeAll() = firebaseDB2.removeAll()

fun getItemCount(): Long {
    val fbItemCount = firebaseDB2.fbItemCountMaps
    return fbItemCount
    }

}

interface CallBackRepoMaps {
fun getMapsCall(mapsList: List<Maps>)
}