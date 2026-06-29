<script setup>
  //Vue 패키지에서 ref라는 함수를 "이름으로 가져오는 것"
  import {ref} from "vue"
  
  /*
  폴더 구조
  src : javascript 코드, .vue 파일을 이 곳에서 작성.
        시작 진입 파일은 src/main.js 
  public : 이미지와 같은 정적 파일, 자원을 이 곳에서 작성
  index.html : Vue 애플리케이션의 컴포넌트 트리는
               id가 app인 div 요소 내부에 렌더링됨
  */

  //ref : 단일 값 상태를 반응형으로 만들 때 사용
  //팔 굽혀 펴기 개수
  let pushUp = ref(0);//0은 초기값을 의미
  //윗몸 일으키기 개수
  let sitUp = ref(0);

  //팔 굽혀 펴기 개수 증가
  const increasePushUp = () => {
    pushUp.value++;
    console.log(`pushUp : ${pushUp.value}`);
  };
  //윗몸 일으키기 개수 증가
  const increaseSitUp = () => {
    sitUp.value++;
    console.log(`sitUp : ${sitUp.value}`);
  };
</script>

<template>
  <div>
    <h1>체력 검사</h1>
    <br>
    <br>
    <ul>
      <li id="pushUp">팔 굽혀 펴기 : {{ pushUp }}</li>
      <li id="sitUp">윗몸 일으켜기 : {{ sitUp }}</li>
    </ul>
    <hr>
    <br>
    <button @click="increasePushUp">팔 굽혀 펴기 증가</button>
    <button @click="increaseSitUp">윗몸 일으키기 증가</button>
  </div>
</template>

<style scoped>

</style>
