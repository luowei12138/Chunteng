let app = new Vue({
    el:"#app",
    data:{
        message:'test001'
    },
    methods:{
        A(){
            console.log(this.message);
        }
    },
    watch:{
        message(){
            this.A();
        }
    }
})