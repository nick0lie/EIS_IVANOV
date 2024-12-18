<template>
  <div>
    <h2>Список парков</h2>
    <ul>
      <li v-for="park in parks" :key="park.id">
        {{ park.name }} ({{ park.location }}) - Вместимость: {{ park.capacity }}
        <span v-if="park.is_open">[Открыт]</span>
        <button @click="deletePark(park.id)">Удалить</button>
      </li>
    </ul>
  </div>
</template>

<script>
import parkService from '@/services/parkService';

export default {
  data() {
    return {
      parks: [],
    };
  },
  methods: {
    async fetchParks() {
      const response = await parkService.getParks();
      this.parks = response.data;
    },
    async deletePark(id) {
      await parkService.deletePark(id);
      this.fetchParks();
    },
  },
  created() {
    this.fetchParks();
  },
};
</script>
