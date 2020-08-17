package com.sky.kotlinstudy.network.bean

/**
 *created skyHuang
 * data 2020/8/13
 **/
class TestBody : BaseResponse<TestBody.Data>() {

    public class Data {
        //        {"children":[],"courseId":13,"id":408,"name":"鸿洋","order":190000,
//        "parentChapterId":407,"userControlSetTop":false,"visible":1}
        var courseId = -1
        var id = -1
        var order = -1
        var parentChapterId = -1
    }
}