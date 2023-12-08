package com.example.mobileapps_testing_codes_use_this_for_practise.Model

class ToDoModel {
    var id: Int = 0
    var status: Int = 0
    var task: String? = null

    //getId
    fun peeId(): Int{
        return id
    }

    //setId
    fun pooId(id: Int) {
        this.id = id
    }


    //getStatus
    fun peeStatus(): Int {
        return status
    }

    //setStatus
    fun pooStatus(status: Int) {
        this.status = status
    }

    //getTask
    fun peeTask():String?{
        return task
    }
    //setTask
    fun pooTask(task: String?) {
        this.task = task
    }
}
