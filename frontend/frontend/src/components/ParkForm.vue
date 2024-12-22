<template>
  <div>
    <h2>Добавить/Обновить парк</h2>
    <form @submit.prevent="submitPark">
      <input
          v-model="park.name"
          placeholder="Название парка"
          required
      />
      <input
          v-model="park.location"
          placeholder="Расположение"
          required
      />
      <input
          v-model.number="park.capacity"
          type="number"
          placeholder="Вместимость"
          required
      />
      <label>
        Открыт:
        <input
            type="checkbox"
            v-model="park.is_open"
            @change="updateIsOpen"
        />
      </label>
      <button type="submit">Сохранить</button>
    </form>
  </div>
</template>

<script>
import parkService from "@/services/parkService";

export default {
  data() {
    return {
      park: {
        id: null,
        name: "",
        location: "",
        capacity: 0,
        is_open: false,
      },
    };
  },
  methods: {
    updateIsOpen(event) {
      this.park.is_open = event.target.checked || false;
    },
    async submitPark() {
      this.park.is_open = !!this.park.is_open;
      if (this.park.id) {
        await parkService.updatePark(this.park);
      } else {
        await parkService.addPark(this.park);
      }
      this.clearForm();
      this.$emit("refresh");
    },
    clearForm() {
      this.park = {
        id: null,
        name: "",
        location: "",
        capacity: 0,
        is_open: false,
      };
    },
    editPark(park) {
      this.park = { ...park };
    },
  },
};
</script>
