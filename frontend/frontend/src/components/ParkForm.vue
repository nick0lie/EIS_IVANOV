<template>
  <div>
    <h2>Добавить/Обновить Парк</h2>
    <form @submit.prevent="submitPark">
      <input v-model="park.name" placeholder="Название парка" required />
      <input v-model="park.location" placeholder="Локация" required />
      <input type="number" v-model="park.capacity" placeholder="Вместимость" required />
      <label>
        Открыт:
        <input type="checkbox" v-model="park.is_open" />
      </label>
      <button type="submit">Сохранить</button>
    </form>
  </div>
</template>

<script>
import parkService from '@/services/parkService';

export default {
  data() {
    return {
      park: {
        id: null,
        name: '',
        location: '',
        capacity: null,
        is_open: false,
      },
    };
  },
  methods: {
    async submitPark() {
      if (this.park.id) {
        await parkService.updatePark(this.park);
      } else {
        await parkService.addPark(this.park);
      }
      this.clearForm();
    },
    clearForm() {
      this.park = { id: null, name: '', location: '', capacity: null, is_open: false };
    },
  },
};
</script>
