<script setup>
import {ref} from 'vue';
import InputName from './components/InputName.vue';

//반응형 상태 정의
const parentName = ref('')

//이벤트 핸들러 함수
function nameChangeHandler(e){
  parentName.value = e.name;
}
</script>

<template>
 <div>
  <InputName @nameChanged="nameChangeHandler"/>
 </div>
 <h3>App 데이터 : {{ parentName }}</h3>
</template>

<style scoped>

</style>
