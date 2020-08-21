package com.sky.kotlinstudy

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.blankj.utilcode.util.LogUtils
import com.sky.kotlinstudy.test.constructor.Student
import com.sky.kotlinstudy.test.constructor.Teacher
import com.sky.kotlinstudy.network.Api
import com.sky.kotlinstudy.network.bean.BaseResponse
import com.sky.kotlinstudy.network.bean.TestBody
import com.sky.kotlinstudy.ui.main.MainFragment
import kotlinx.coroutines.*
import okhttp3.Call
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.CoroutineContext
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    val student: Student =
        Student("sky", 27, 3)
    val intArr = intArrayOf(21, 40, 11, 33, 78)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commitNow()
//        }
        println("日志打印===========")
        student.show()
        intArr.filter { i ->
            i % 3 == 0
        }.forEach { i -> println(i) }
        Teacher.getTeacher()
        var a = method { method3(2) }

        val b = ::method//将函数转化为对象
        val c = ::method3
        c(3)
        val d = method2(2) //将函数返回值赋值给变量
        b { method2(3) }
        xieChen()
        CoroutineScope(Dispatchers.Main).launch(Dispatchers.Main) {
            Log.i("数据请求", "当前线程名1：->" + Thread.currentThread().name)
            val resp = withContext(Dispatchers.IO) {
                Api.test().execute().body()
            }
            LogUtils.i(resp?.data)
        }
    }

    fun viewMethod(view: View?) {
        println(view?.id)
    }

    //函数嵌套
    fun login(user: String, password: String, illegalStr: String) {
        require(password.isEmpty())
        requireNotNull(user.isEmpty()) { "输出的信息" }
        fun validate(value: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException(illegalStr)
            }
        }
        validate(user)
        validate(password)
    }

    //数组、集合
    val intArray = intArrayOf(2, 2, 3)
    val strlist = listOf("2", "3", "3", "4", "2", "333", "222")

    //filter：对每个元素进行过滤操作，如果 lambda 表达式中的条件成立则留下该元素，否则剔除，最终生成新的集合
    val newList: List<String> = strlist.filter { s: String ->
        s.equals("2")
    }

    //map：遍历每个元素并执行给定表达式，最终形成新的集合
    val newList2: List<Int> = intArray.map { i ->
        i + 1 // 👈 每个元素加 1
    }

    //flatMap：遍历每个元素，并为每个元素创建新的集合，最后合并到一个集合中
    val newList3: List<String> = intArray.flatMap { i ->
        listOf("${i + 1}", "a") // 👈 生成新集合
    }

    fun arrayAndList() {
        intArray.forEach { int ->
            print(int)
        }
        strlist.forEach { s ->
            print(s)
        }
    }

    //range
    val range = 0..1000
    val range2: IntRange = 0 until 10

    fun rangeTest(): Int {
        var t = 0;
        for (i in range) {
            print(i)
        }

        for (i in range step 3) {//间隔输出从第一个开始
            print(i)
            t = i;
        }
        //if 最后一行作为返回值返回 when与 in(范围) is
        t = if (t % 2 == 0) {
            print(t)
            t + 1
        } else {
            t + 2
        }
        return t
    }

    //Sequence 惰性集合
    fun sequenceTest() {
        val list = listOf(1, 2, 3, 4)
        val result: List<Int> = list
            .map { i ->
                println("Map $i")
                i * 2
            }
            .filter { i ->
                println("Filter $i")
                i % 3 == 0
            }
        println(result.first()) // 👈 只取集合的第一个元素
    }

    fun whenTest(x: Int) {
        when (x) {
            1 -> {
            }
            2, 3 -> {
            }
            in 4..10 -> {
            }
//            is 判断条件
            else -> {
            }
        }
    }

    //数组不支持协变
    val strs: Array<String> = arrayOf("a", "b", "c")

//    val anys: Array<Any> = strs // compile-error: Type mismatch
    //java
//    String[] strs = {"a", "b", "c"};
//    Object[] objs = strs; // success

    //java list 不支持协变
//    List<String> strList = new ArrayList<>();
//    strList.add("a");
//    strList.add("b");
//    strList.add("c"); // 👈 添加元素繁琐

    //kotlin list 支持
    val strList = listOf("a", "b", "c")
    val anys: List<Any> = strList // success

    //set
    val strSet = setOf("a", "b", "c")

    //map mutableMapOf()
    var map = mapOf("key1" to 2, "key2" to "3")
    var mutableMap = mutableMapOf("key1" to 3)
    fun mapTest() {
//        map["key1"] = 12  mapOf不可被修改
        mutableMap["key1"] = 12
        map.toMutableMap()["key2"] = "可变嘻嘻"
    }
//上面修改 Map 值的例子中，创建函数用的是 mutableMapOf() 而不是 mapOf()，因为只有 mutableMapOf() 创建的 Map 才可以修改。Kotlin 中集合分为两种类型：只读的和可变的。这里的只读有两层意思：
//
//集合的 size 不可变
//集合中的元素值不可变
//以下是三种集合类型创建不可变和可变实例的例子：
//
//listOf() 创建不可变的 List，mutableListOf() 创建可变的 List。
//setOf() 创建不可变的 Set，mutableSetOf() 创建可变的 Set。
//mapOf() 创建不可变的 Map，mutableMapOf() 创建可变的 Map。

    //「参数或者返回值为函数类型的函数」，在 Kotlin 中就被称为「高阶函数」——Higher-Order Functions。
    fun method(method: (Int) -> String): String {
        return method(3)
    }

    fun method4(param: Int): (Int) -> String {//返回值为函数的高阶函数
        if (param == 2) {
            return ::method2
        } else {
            return ::method3
        }
    }

    fun method2(a: Int): String {
        return "高阶函数"
    }

    fun method3(a: Int): String {
        return a.toString()
    }

    //协程的使用方式
    fun xieChen() {
        //方式1 线程阻塞
//        runBlocking {
//
//        }

        //方式2  和app的生命周期一样，且不能取消
//        GlobalScope.launch(){
//
//        }

        //方式3
        // 方法三，自行通过 CoroutineContext 创建一个 CoroutineScope 对象
//                                    👇 需要一个类型为 CoroutineContext 的参数
        var iv: ImageView = findViewById(R.id.iv)
        CoroutineScope(Dispatchers.Main).launch(Dispatchers.Main) {
            Log.i("111", "当前线程名1：->" + Thread.currentThread().name)
            val bitmap = withContext(Dispatchers.IO) {
                Log.i("111", "当前线程名2：->" + Thread.currentThread().name)
                getImage("https://d47jbcq60tnr6.cloudfront.net/2020112/10841-c19x3h.dkzt6.jpg")
            }
            iv.setImageBitmap(bitmap)
        }
    }

    fun getImage(url: String): Bitmap {
        val urlParam = URL(url)
        val openOption = urlParam.openConnection() as HttpURLConnection
        openOption.requestMethod = "GET"
        openOption.connect()
        val inputStream = openOption.inputStream
        return BitmapFactory.decodeStream(inputStream)
    }
}
