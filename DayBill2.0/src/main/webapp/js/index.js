$(function() {
    // 键盘初始化参数 type: {纯数字 = 0， 小数 = 1， 身份证 = 2}
    var type;
    var money;
    var time;
    $('.num').bind("click", function () {
        $(this).mobileKeyboard({type: 0});
    });

    $('.float').bind("click", function () {
        $(this).mobileKeyboard({type: 1});
    });

    $('.idcard').bind("click", function () {
        $(this).mobileKeyboard({type: 2});
    });
    $(".footer-content>div").click(function () {
        $(".money").val("");
        $(".myinput").css("display","block");
        type=$(this).children().children("span").html();
        $(".typeInput").val(type);
        // console.log(type);
    });
    $("#gobtn").click(function () {
        money=$(".money").val();
        // console.log(money);
        $(".myinput").css("display","none");
        var tr=$("<tr></tr>");
        var tab=$("#tb-body");
        tr.appendTo(tab);
        var td1=$("<td></td>>");
        var td2=$("<td></td>>");
        var td3=$("<td></td>>");
        var td4=$("<td><span class='glyphicon glyphicon-pencil'></span></td>");
        var td5=$("<td><span class='glyphicon glyphicon-remove' id='td-delete'></span></td>>");
        getTime();
        td1.html(time);
        td2.html(type);
        td3.html(money);
        td1.appendTo(tr);
        td2.appendTo(tr);
        td3.appendTo(tr);
        td4.appendTo(tr);
        td5.appendTo(tr);
        td5.click(function () {
            $(this).parent().empty();
        });
        td4.click(function () {
            $(".myinput").css("display","block");
            $(".money").val(td3.html());
            td3.css("color","red");
            $(".money").on("input propertychange",function () {
                    td3.html($(".money").val());
            });
             type=$(this).prev().prev().html();
             time=$(this).prev().prev().prev().html();
            $("#gobtn").click(function () {
                td4.parent().empty();
            });

        });
    });
    function getTime() {
        var myDate = new Date;
        var year = myDate.getFullYear(); //获取当前年
        var mon = myDate.getMonth() + 1; //获取当前月
        var date = myDate.getDate(); //获取当前日
        var h = myDate.getHours();//获取当前小时数(0-23)
        var m = myDate.getMinutes();//获取当前分钟数(0-59)
        var s = myDate.getSeconds();//获取当前秒
        var week = myDate.getDay();
        // var weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
        time=mon+"月"+date+"日";
    }
})