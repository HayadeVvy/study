<script setup>
//(부모에서 자식으로) 컴포넌트들은 속성(Props)를 통해서 
//자식 컴포넌트로 정보를 전달함

defineProps({
    name:String,
    checked:Boolean
})
</script>
<template>
    <li>
        <input type="checkbox" :checked="checked"> {{ name }}
    </li>
</template>