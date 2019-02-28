/**
 * Bolg main JS.
 * Created by waylau.com on 2017/3/9.
 */
"use strict";
//# sourceURL=main.js
var httpurl = "http://localhost:3333/"
// DOM 加载完再执行
$(function () {
    function resize() {
        // 获取屏幕的宽
        var windowWidth = $(window).width();
        var isSmallScreen = windowWidth < 768;
        $('#main_ad > .carousel-inner >.item').each(function (i, item) {
            var $item = $(item); //dom对象转换
            var imgSrc = $item.data(isSmallScreen ? 'image-xs' : 'image-lg')
            $item.css('backgroundImage', 'url("' + imgSrc + '")')
            if (isSmallScreen) {
                $item.html('<img src="' + imgSrc + '" alt="">');
            } else {
                $item.empty();
            }
        });
    }

    // 判断屏幕大小
    // 返回顶部的效果事件
    NProgress.start();

    $(window).scroll(function () {  //只要窗口滚动,就触发下面代码
        var scrollt = document.documentElement.scrollTop + document.body.scrollTop; //获取滚动后的高度
        if (scrollt > 200) {  //判断滚动后高度超过200px,就显示
            $("#goToTop").fadeIn(400); //淡出
        } else {
            $("#goToTop").stop().fadeOut(400); //如果返回或者没有超过,就淡入.必须加上stop()停止之前动画,否则会出现闪动
        }
    });
    $("#goToTop").click(function () { //当点击标签的时候,使用animate在200毫秒的时间内,滚到顶部
        $("html,body").animate({scrollTop: "0px"}, 200);
    });
    NProgress.done();
    $(window).on('resize', resize).trigger('resize');








    //将form表单转换为json数据
    $.fn.serializeJson=function(){
        var serializeObj={};
        var array=this.serializeArray(); //将form表单序列化数组对象
        var str=this.serialize();  //将form表单序列化字符串
        $(array).each(function(){  //遍历表单数组拼接json串
            if(serializeObj[this.name]){
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value);
                }else{
                    serializeObj[this.name]=[serializeObj[this.name],this.value];
                }
            }else{
                serializeObj[this.name]=this.value;
            }
        });
        return serializeObj;
    };

    $('#login_pass').click(function () {
        var arry = $('#login_form').serializeJson();
        // json添加元素
        // arry.memberId = "21312"
        $.ajax({
            url: httpurl+"/api-a/login",
            dataType: "json",
            type: "post",
            data:JSON.stringify(arry),
            contentType: "application/json",
            success: function (data) {
                var newData = JSON.stringify(data);
                var json= eval("("+newData+")");
                $("#memberId").val(json.memberId);
                $("#login").hide();
                $("#login_meta").hide();
                setCookie("memberId",json.memberId);
                $("#loginout_meta").show();
            }
        })
    });
    // 注册
    $('#register_pass').click(function () {
        var arry = $('#register_form').serializeJson();
        $.ajax({
            url: httpurl+"/api-a/register",
            dataType: "json",
            type: "post",
            data:JSON.stringify(arry),
            contentType: "application/json",
            success: function (json) {
                alert(json)
            }
        })
    });
    $('#loginout_meta').click(function () {
            delCookie("memberId");
        $("#login_meta").show();
        $("#loginout_meta").hide();
    });
    //写cookies
    function setCookie(name,value)
    {
        var Days = 30;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days*24*60*60*1000);
        document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
    }
    // 用户是否已经登陆
    var memberId = getCookie("memberId");
    if(memberId != null) {
        $("#login_meta").hide();
        $("#loginout_meta").show();
    }
    function getCookie(name)
    {
        var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
        if(arr=document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return null;
    }
    function delCookie(name)
    {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval=getCookie(name);
        if(cval!=null)
            document.cookie= name + "="+cval+";expires="+exp.toGMTString();
    }
});

