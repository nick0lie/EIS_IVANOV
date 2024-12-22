<template>
  <div>
    <h2>Список парков</h2>
    <ul>
      <li v-for="park in parks" :key="park.id">
        {{ park.name }} ({{ park.location }}) - Вместимость: {{ park.capacity }}
        Открыт: {{ park.is_open ? "Да" : "Нет" }}
        <button @click="$emit('edit', park)">Редактировать</button>
        <button @click="deletePark(park.id)">Удалить</button>
      </li>
    </ul>
  </div>
</template>

<script>
import parkService from "@/services/parkService";

export default {
  data() {
    return {
      parks: [],
    };
  },
  methods: {
    async fetchParks() {
      this.parks = (await parkService.getAllParks()).data;
    },
    async deletePark(id) {
      await parkService.deletePark(id);
      this.fetchParks();
    },
  },
  mounted() {
    this.fetchParks();
  },
};
</script>
