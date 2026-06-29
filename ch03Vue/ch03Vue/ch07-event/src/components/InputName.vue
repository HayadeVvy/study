<script setup>
import {ref} from "vue"

let name = ref('')
</script>

<template>
<!--
속성(props)은 부모 컴포넌트에서 자식 컴포넌트로 정보를 전달하는
방법을 제공.
반대로 자식 컴포넌트가 부모 컴포넌트로 정보를 전달하기 위해서는
사용자 정의 이벤트를 사용해야 함. 자식 컴포넌트는 이벤트를
발신(emit events)하고, 부모 컴포넌트는 자식 컴포넌트가 발신한
이벤트를 v-on 디렉티브를 이용해 수신함.

자식 컴포넌트에서
this.$emit('event-name',eventArgs1,eventArgs2...)

부모 컴포넌트에서
<child-componet @event-name="handlerMethod"/>

사용자 정의 이벤트를 이용한 정보 전달
$emit() 내장 메서드는 직계 부모 컴포넌트로만 이벤트 정보를 전송함
--> 
    <div style="border:solid 1px gray; padding:5px;">
        이름 : <input type="text" v-model="name"/>
        <!--$emit : 자식 컴포넌트 -> 부모 컴포넌트로 이벤트를
        전달(발신)하는 기능-->
        <button @click="$emit('nameChanged',{name})">이벤트 발신</button>
    </div>
</template>