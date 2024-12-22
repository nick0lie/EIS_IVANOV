<template>
  <div id="app">
    <h1>Управление парками</h1>
    <ParkForm @refresh="refreshList" ref="form" />
    <ParkList @edit="editPark" ref="list" />
  </div>
</template>

<script>
import ParkForm from "@/components/ParkForm.vue";
import ParkList from "@/components/ParkList.vue";

export default {
  components: {
    ParkForm,
    ParkList,
  },
  methods: {
    refreshList() {
      this.$refs.list.fetchParks();
    },
    editPark(park) {
      this.$refs.form.editPark(park);
    },
  },
};
</script>
