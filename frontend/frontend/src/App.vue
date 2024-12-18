<template>
  <div id="app">
    <h1>Управление парками</h1>
    <ParkForm />
    <ParkList />
  </div>
</template>

<script>
import ParkList from '@/components/ParkList.vue';
import ParkForm from '@/components/ParkForm.vue';

export default {
  components: {
    ParkList,
    ParkForm,
  },
};
</script>
