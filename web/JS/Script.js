/**
 * Created with IntelliJ IDEA.
 *User: YEN
 *Date: 2016/7/31
 *Time: 16:29
 */

//-----------------------------------index-------------------------------------------

function doDelete(id) {
    function doDeleteDate(id) {
        $.ajax({
            type : "post",
            url : "DeleteServlet",
            dataType : 'text',
            data : {
                'id' : id
            },
            success : function(data, textStatus){
                if (data.replace(/^\s*|\s*$/g, '')  == 'success') {
                    location.href = 'SelectServlet';
                } else {
                    alert('删除失败');
                }
            },
            error : function() {
                alert('请求数据失败!');
            }
        });
    }
}

function jump(id) {
    location.href ='OneMsgServlet?id=' + id;
}

function domove() {
    location.href ='insert.jsp';
}



//--------------------------------------adminlogin----------------------------------------
function doAdminLogin() {
    var loginName=$('#loginName').val();
    var password=$('#password').val();
    if('' == loginName || '' == password){
        alert('用户名或密码不能为空！');
        return false;
    }

    $.ajax({
        type : "post",
        url : "adminLoginServlet",
        dataType : 'text',
        data : {
            'loginName' : loginName,
            'password' : password
        },
        success : function(data, textStatus){
            if(data.replace(/^\s*|\s*$/g, '')  == 'success') {
                location.href = 'SelectServlet';
            } else {
                alert('密码错误!');
            }
        },
        error : function() {
            alert('请求数据失败!');
        }
    });

}

//---------------------userlogin-------------------------------------
function doUserLogin() {
    var loginName=$('#loginName').val();
    var password=$('#password').val();
    if('' == loginName || '' == password){
        alert('用户名或密码不能为空！');
        return false;
    }

    $.ajax({
        type : "post",
        url : "userLoginServlet",
        dataType : 'text',
        data : {
            'loginName' : loginName,
            'password' : password
        },
        success : function(data, textStatus){
            if(data.replace(/^\s*|\s*$/g, '')  == 'success') {
                location.href = 'SelectServlet';
            } else {
                alert('密码错误!');
            }
        },
        error : function() {
            alert('请求数据失败!');
        }
    });
}



/*---------------------changepasswod------------------------------------- */

function doChangePassword() {
   
    var oldpassword=$('#oldpassword').val();
    var newpassword=$('#newpassword').val();
    var repassword=$('#repassword').val();
    
    if('' == oldpassword || '' == newpassword || ''== repassword){
        alert('密码不能为空！');
        return false;
    }
    if(newpassword != repassword){
        alert('两次密码不一致！');
        return false;
    }

    $.ajax({
        type : "post",
        url : "ChangePasswordServlet",
        dataType : 'text',
        data : {
            'oldpassword' : oldpassword,
            'newpassword' : newpassword
        },
        success : function(data, textStatus){
            if(data.replace(/^\s*|\s*$/g, '')  == 'success') {
                alert('修改密码成功!');
                location.href = 'SelectServlet';
            } else {
                alert('旧密码错误!');
            }
        },
        error : function() {
            alert('请求数据失败!');
        }
    });
}



// -------------------------------------insert--------------------------------------------

function doInsert() {
    var content = $('#content').val();

    if (''==content ) {
        alert('输入内容不能为空！');
        return false;
    }

    $.ajax({
        type : "post",
        url : "InsertServlet",
        dataType : 'text',
        data : {
            'content' : content
        },
        success : function(data, textStatus){
            if(data.replace(/^\s*|\s*$/g, '') == 'success') {
                location.href = 'SelectServlet';
            } else {
                alert('您被禁止发言!');
            }
        },
        error : function() {
            alert('请求数据失败!');
        }
    });
}


//--------------------update-----------------------------------------
function doUpdata(id) {
    var context = $('#context').val();
    if (context == '') {
        alert('对不起，输入不能为空')
        return;
    }

    $.ajax({
        type : "post",
        url : "UpdataServlet",
        dataType : 'text',
        data : {
            'id': id,
            'context' : context
        },
        success : function(data, textStatus){
            if(data.replace(/^\s*|\s*$/g, '') == 'success') {
                location.href = 'SelectServlet';
            } else {
                alert('修改失败!');
            }
        },
        error : function() {
            alert('请求数据失败！');
        }
    });
}



//----------------------adduser---------------------------------

function doAddUser() {
    var loginName = $('#loginName').val();
    var password1 = $('#password1').val();
    var password2 = $('#password2').val();

    if (loginName == '' || password1 == ''|| password2 == '') {
        alert('输入信息不完整');
        return;
    }
    if (password1 != password2) {
        alert('密码不一致');
        return;
    }
    $.ajax({
        type : "post",
        url : "AddUserServlet",
        dataType : 'text',
        data : {
            'loginName' : loginName,
            'password' : password1
        },
        success : function(data, textStatus){
            if(data.replace(/^\s*|\s*$/g, '') == 'success') {

                location.href = 'SelectUserServlet';
            } else {
                alert('添加失败!');
            }
        },
        error : function() {
            alert('请求数据失败!');
        }
    });
}