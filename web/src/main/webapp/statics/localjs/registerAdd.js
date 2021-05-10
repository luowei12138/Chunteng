// 医保卡号验证标识
let idMedicareRes = true;

//加载进度条
axios.interceptors.request.use(config => {
    NProgress.start();
    return config;
})
//结束进度条
axios.interceptors.response.use(reps => {
    NProgress.done();
    return reps;
})

//Vue(axios)请求
let app = new Vue({
    /*动态加载就诊科室列表json*/
    el: '#app',
    data: {
        idCard: '',
        name: '',
        phone: '',
        birthday: '',
        sex: '',
        address: '',
        sign: '',
        departmentId: 0,
        idMedicare: '',//医保卡

        patientId: '',
        scheduleId: '',
        roomId: '',
        isMedicare: '',
        userId: '',
        fee: 50,
        payFee: 10,
        medicareFee: 40,
    },
    methods: {
        //初始化就诊科室
        getDepartmentList() {
            axios.get(projectName + '/api/department/getDepartmentList.json',)
                .then(response => {
                    let data = response.data.data;
                    let htm = `<option selected value='0'>---请选择就诊科室---</option>`;
                    for (let i = 0; i < data.length; i++) {
                        htm += `<option value="${data[i]["id"]}">${data[i]["name"]}</option>`;

                    }
                    $('#departmentId').html(htm);

                })
                .catch(error => {
                    console.log(error);
                })
        },
        //输入身份证满18位后，加载身份信息
        getPatientByIdCard() {
            let urlSearchParams = new URLSearchParams();
            urlSearchParams.append('idCard',this.idCard);
            axios.post(projectName + '/api/patient/getPatientByIdCard.json', urlSearchParams)
                .then(response => {
                    let data = response.data;
                    if (data.code == 200) {
                        this.$data.name = data.data.name;
                        this.$data.phone = data.data.phone;
                        this.$data.birthday = data.data.birthday;
                        this.$data.sex = data.data.sex;
                        this.$data.address = data.data.address;

                        this.$data.patientId = data.data.id;
                    } else {
                        alert("请先注册就诊卡")
                    }
                    console.log(response)
                })
                .catch(error => {
                    console.log(error)
                })
        },
        //输入完时间段，加载就诊医师
        getDoctorList() {
            let urlSearchParams = new URLSearchParams();
            urlSearchParams.append('departmentId', this.departmentId);
            urlSearchParams.append('sign', this.sign);

            axios.post(projectName + '/api/schedule/getDoctorList.json', urlSearchParams)
                .then(response => {
                    let data = response.data;
                    if (data.code == 200) {
                        data = data.data;
                        var options = "<option value=\"\">--请选择--</option>";
                        for (var i = 0; i < data.length; i++) {
                            options += "<option value=\"" + data[i].userId + "\" data-down=\"" + data[i].roomName + "\" data-sche=\"" + data[i].id + "\" data-roomid=\"" + data[i].roomId + "\" >" + data[i].doctorName + "</option>";
                        }

                        $("#doctorId").html(options);
                    } else {
                        var options = "<option value=\"\">--请重新选择时间段--</option>";
                        $("#doctorId").html(options);
                        alert("无可用就诊医生，请重新选择时间段");
                    }
                }).catch(error => {
                var options = "<option value=\"\">--请重新选择时间段--</option>";
                $("#doctorId").html(options);
                console.log(error);
            })
        },
        //判断医保卡，是否已存在
        getPatientByIdMedicare() {
            let urlSearchParams = new URLSearchParams();
            urlSearchParams.append('idMedicare', this.idMedicare);
            axios.post(projectName + "/api/patient/getPatientByIdMedicare.json", urlSearchParams)
                .then(response => {
                    let data = response.data;
                    if (data.code == 200) {
                        data = data.data;
                        if (data != null) {
                            idMedicareRes = false;
                            $("#idMedicareSpan").show();
                            $("#idMedicareSpan").text("该医保卡号已存在，请重新输入...");
                        }
                    } else {
                        idMedicareRes = true;
                        $("#idMedicareSpan").hide();
                    }
                }).catch(error => {
                alert("就诊卡信息查询失败");
            })
        },
        //医保列表
        isMedicareFun(val) {
            let urlSearchParams = new URLSearchParams();
            if (val == 2) {
                $("#idMedicareDiv").show();
                $("#idMedicare").attr('required', 'true');
                $("#isMedicare").val(2);
                this.$data.isMedicare = 2;
                urlSearchParams.append('sign', val);
            } else {
                $("#idMedicareDiv").hide();
                $("#idMedicare").removeAttr("required");
                $("#isMedicare").val(1);
                this.$data.isMedicare = 1;
                urlSearchParams.append('sign', '');
            }

            axios.post(projectName + "/api/register/createFee.json", urlSearchParams)
                .then(response => {
                    let data = response.data;
                    if (data.code == 200) {
                        data = data.data;
                        $("#fee").val(data.fee);
                        $("#medicareFee").val(data.medicareFee);
                        $("#payFee").val(data.payFee);
                    } else {
                        alert("挂号费加载失败");
                    }
                }).catch(error => {
                alert("挂号费加载失败");
            })

            $("#feeDiv").show();
            $("#medicareFeeDiv").show();
            $("#payFeeDiv").show();

            // 显示保存按钮
            $("#send").attr("style", "visibility: visible;");
        },
        //提交
        registerAdd() {

            var scheduleId = $("#doctorId").find("option:selected").data("sche");
            this.$data.scheduleId = scheduleId;
            var roomId = $("#doctorId").find("option:selected").data("roomid");
            this.$data.roomId = roomId;

            let urlSearchParams = new URLSearchParams();
            urlSearchParams.append('idMedicare', this.idMedicare);
            urlSearchParams.append('sign', this.sign);

            urlSearchParams.append('patientId', this.patientId);
            urlSearchParams.append('scheduleId', this.scheduleId);
            urlSearchParams.append('roomId', this.roomId);
            urlSearchParams.append('isMedicare', this.isMedicare);
            urlSearchParams.append('userId', this.userId);
            urlSearchParams.append('fee', this.fee);
            urlSearchParams.append('payFee', this.payFee);
            urlSearchParams.append('medicareFee', this.medicareFee);
            urlSearchParams.append('departmentId', this.departmentId);

            axios.post(projectName + "/api/register/register", urlSearchParams)
                .then(response => {
                    let data = response.data;
                    if (data.code == 200) {
                        data = data.data;
                        console.log("添加成功");
                        location= "/api/register/registerList";
                    } else {
                        alert("添加失败");
                    }
                }).catch(error => {
                alert("添加失败");
            })
        },
    },
    created() {
        this.getDepartmentList();
    },
    watch: {
        idCard() {
            if (this.idCard.length == 18) {
                this.getPatientByIdCard();
            }
        },
        sign() {
            if (this.sign != " " || this.departmentId != " ") {
                this.getDoctorList();
            }
        },
        idMedicare() {
            if (this.idMedicare != "") {
                this.getPatientByIdMedicare();
            }
        }
    }
})

//动态加载就诊科室列表json
$(function () {

    // 时间段处理
    let date = new Date();
    let hour = date.getHours();
    // 当前时间为下午，隐藏上午时间段
    if (hour > 12) {
        $("#sign option[value = 1]").hide();
    }

    // 返回按钮事件
    $("#back").on("click", function () {
        window.location.href = projectName + "/api/users/index";
    });

    //动态加载就诊科室列表json
    /*$.ajax({
        type:"GET",//请求类型
        url: projectName + "/api/department/getDepartmentList.json",//请求的url
        dataType:"json",//ajax接口（请求url）返回的数据类型
        success:function(data){//data：返回数据（json对象）
            if(data.code == 200){
                data = data.data;
                var options = "<option value=\"\">--请选择--</option>";
                for(var i = 0; i < data.length; i++){
                    options += "<option value=\""+data[i].id+"\">"+data[i].name+"</option>";
                }
                $("#departmentId").html(options);
            }
        },
        error:function(){//当访问时候，404，500 等非200的错误状态码
            alert("加载用户类型失败！");
        }
    });*/

    // 根据身份证号查询就诊卡信息
    /*$("#idCard").on("change",function () {
        $("#idMedicare").val("");
        $("#idMedicare").removeAttr("readonly")

        var idCard = $("#idCard").val();
        $.ajax({
            type: "POST",//请求类型
            url: projectName + "/api/patient/getPatientByIdCard.json",//请求的url
            data: {idCard: idCard},
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                if (data.code == 200) {
                    var data = data.data;
                    $("#name").val(data.name);
                    $("#phone").val(data.phone);
                    $("#relatives_birthday").val(data.birthday);
                    var sex = "";
                    if(data.sex == 1){
                        sex = "女";
                    } else {
                        sex = "男";
                    }
                    $("#relatives_gender").val(sex);
                    $("#address").val(data.address);

                    // 若有医保卡，则不需要输入
                    if(data.idMedicare != null && data.idMedicare != ''){
                        $("#idMedicare").val(data.idMedicare);
                        $("#idMedicare").attr("readonly","readonly");
                    }

                    $("#patientId").val(data.id);
                } else {
                    alert("就诊卡信息查询失败,请先创建就诊卡!")
                }
            },
            error:function(){
                alert("就诊卡信息查询失败,请先创建就诊卡!");
            }
        });
    });*/

});

// 医保卡号重复校验
$("#idMedicare").on("change", function () {
    let idMedicare = $("#idMedicare").val();
    /* $.ajax({
         type: "POST",//请求类型
         url: projectName + "/api/patient/getPatientByIdMedicare.json",//请求的url
         data: {idMedicare: idMedicare},
         dataType: "json",//ajax接口（请求url）返回的数据类型
         success: function (data) {//data：返回数据（json对象）
             if (data.code == 200) {
                 var data = data.data;
                 if (data != null) {
                     idMedicareRes = false;
                     $("#idMedicareSpan").show();
                     $("#idMedicareSpan").text("该医保卡号已存在，请重新输入...");
                 }
             } else {
                 idMedicareRes = true;
                 $("#idMedicareSpan").hide();
             }
         },
         error: function () {
             alert("就诊卡信息查询失败");
         }
     });*/
});

// 选择完就诊科室和时间段后，动态加载医生列表
function signFun() {
    $("#roomNameDiv").hide();

    var sign = $("#sign").find("option:checked").val();
    var departmentId = $("#departmentId").find("option:checked").val();
    // console.log("departmentId:" + departmentId)

    if (departmentId == "") {
        alert("请先选择就诊科室")
    }

    // 选择完时间段，动态加载医生列表
    /*if (sign != 0 && departmentId != "") {
        $.ajax({
            type: "POST",//请求类型
            url: projectName + "/api/schedule/getDoctorList.json",//请求的url
            data: {departmentId: departmentId, sign: sign},
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                if (data.code == 200) {
                    data = data.data;
                    var options = "<option value=\"\">--请选择--</option>";
                    for (var i = 0; i < data.length; i++) {
                        options += "<option value=\"" + data[i].userId + "\" data-down=\"" + data[i].roomName + "\" data-sche=\"" + data[i].id + "\" data-roomid=\"" + data[i].roomId + "\" >" + data[i].doctorName + "</option>";
                    }
                    $("#doctorId").html(options);
                } else {
                    var options = "<option value=\"\">--请重新选择时间段--</option>";
                    $("#doctorId").html(options);
                    alert("无可用就诊医生，请重新选择时间段");
                }
            },
            error: function () {//当访问时候，404，500 等非200的错误状态码
                var options = "<option value=\"\">--请重新选择时间段--</option>";
                $("#doctorId").html(options);
                alert("无可用就诊医生，请重新选择时间段");
            }
        });
    }*/

}

// 点击使用医保按钮
function isMedicareFun() {
    $("#idMedicareDiv").show();
    $("#idMedicare").attr('required', 'true');
    // 是否使用医保卡 1-->未使用，2-->使用
    $("#isMedicare").val(2);

    $.ajax({
        type: "POST",//请求类型
        url: projectName + "/api/register/createFee.json",//请求的url
        data: {sign: "medicare"},
        dataType: "json",//ajax接口（请求url）返回的数据类型
        success: function (data) {//data：返回数据（json对象）
            if (data.code == 200) {
                data = data.data;
                $("#fee").val(data.fee);
                $("#medicareFee").val(data.medicareFee);
                $("#payFee").val(data.payFee);
            } else {
                alert("挂号费加载失败");
            }
        },
        error: function () {//当访问时候，404，500 等非200的错误状态码
            alert("挂号费加载失败");
        }
    });

    $("#feeDiv").show();
    $("#medicareFeeDiv").show();
    $("#payFeeDiv").show();

    // 显示保存按钮
    $("#send").attr("style", "visibility: visible;");

}

function noMedicareFun() {
    $("#idMedicareDiv").hide();
    $("#idMedicare").removeAttr("required");
    // 是否使用医保卡 1-->未使用，2-->使用
    $("#isMedicare").val(1);

    $.ajax({
        type: "POST",//请求类型
        url: projectName + "/api/register/createFee.json",//请求的url
        dataType: "json",//ajax接口（请求url）返回的数据类型
        success: function (data) {//data：返回数据（json对象）
            if (data.code == 200) {
                data = data.data;
                $("#fee").val(data.fee);
                $("#medicareFee").val(data.medicareFee);
                $("#payFee").val(data.payFee);
            } else {
                alert("挂号费加载失败");
            }
        },
        error: function () {//当访问时候，404，500 等非200的错误状态码
            alert("挂号费加载失败");
        }
    });

    $("#feeDiv").show();
    $("#medicareFeeDiv").show();
    $("#payFeeDiv").show();

    // 显示保存按钮
    $("#send").attr("style", "visibility: visible;");
}

// 提交表单校验
$("#addRegisterForm").submit(function () {
    if (!idMedicareRes) {
        return false;
    }
});

// 重新选择就诊科室
function departmentIdFun() {
    $("#sign").val("");
    var options = "<option value=\"\">--请先选择就诊科室和时间段--</option>";
    $("#doctorId").html(options);
    // $("#doctorId").val("");
    $("#roomNameDiv").hide();
}

// 选择完就诊医师，动态加载就诊房间、ScheduleId和roomId
function doctorFun() {
    // 就诊房间名称
    var roomName = $("#doctorId").find("option:selected").data("down");
    // scheduleId
    var scheduleId = $("#doctorId").find("option:selected").data("sche");
    // console.log("scheduleId:" + scheduleId);
    $("#scheduleId").val(scheduleId);
    // roomId
    var roomId = $("#doctorId").find("option:selected").data("roomid");
    // console.log("roomId:" + roomId);
    $("#roomId").val(roomId);

    if (roomName != 0) {
        $("#roomName").val(roomName);
        $("#roomNameDiv").show();
    } else {
        $("#roomNameDiv").hide();
    }
}