Vue.component('pagination',{
    data(){
        return {
            pageCount:0
        };
    },
    props:[
        'total','pageNum','pageSize'
    ],
    methods:{
        jumpTo:function(val){
            this.pageNum = val;
            this.$emit('jump',val);
        },
    },
    watch:{
        total:function(val) {
            this.pageCount = Math.ceil(this.total/this.pageSize);
        },
        pageSize:function(val){
            this.pageCount = Math.ceil(this.total/this.pageSize);
        }
    },
    template:`
    <ul class="pagination" style="margin-top: 0%;float: right;" v-if="pageCount>0">
        <li class="page-item" v-if="pageNum>0"><span v-on:click="jumpTo(pageNum-1)">&laquo;</span></li>
        <li class="page-item" v-if="pageNum>2"><span v-on:click="jumpTo(0)">1</span></li>
        <li class="page-item" v-if="pageNum>3"><span >…</span></li>
        <li class="page-item" v-if="pageNum>1"><span v-on:click="jumpTo(pageNum-2)">{{pageNum-1}}</span></li>
        <li class="page-item" v-if="pageNum>0"><span v-on:click="jumpTo(pageNum-1)">{{pageNum}}</span></li>
        <li class="page-item active" v-if="pageNum>=0"><span >{{pageNum + 1}}</span><li>
        <li class="page-item" v-if="pageNum < pageCount-1"><span v-on:click="jumpTo(pageNum+1)">{{pageNum + 2}}</span></li>
        <li class="page-item" v-if="pageNum < pageCount-2"><span v-on:click="jumpTo(pageNum+2)">{{pageNum + 3}}</span></li>
        <li class="page-item" v-if="pageNum < pageCount-4"><span >…</span><li>
        <li class="page-item" v-if="pageNum < pageCount-3"><span v-on:click="jumpTo(pageCount-1)">{{pageCount}}</span></li>
        <li class="page-item" v-if="pageNum < pageCount-1"><span v-on:click="jumpTo(pageNum+1)">&raquo;</span></li>
    </ul>
    `
});
