$(function(){
    // 键盘初始化参数 type: {纯数字 = 0， 小数 = 1， 身份证 = 2}
    $('.num').bind("click", function(){
        $(this).mobileKeyboard({type: 0});
    });

    $('.float').bind("click", function(){
        $(this).mobileKeyboard({type: 1});
    });

    $('.idcard').bind("click", function(){
        $(this).mobileKeyboard({type: 2});
    });
});
