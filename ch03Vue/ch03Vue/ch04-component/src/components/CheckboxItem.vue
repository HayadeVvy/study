<script setup>
import {ref} from "vue";

let checked = ref(false);
</script>

<template>
    <li>
        <input type="checkbox" v-model="checked">옵션1
    </li>
</template>