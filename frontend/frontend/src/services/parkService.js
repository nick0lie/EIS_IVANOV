import axios from 'axios';

const API_URL = 'http://localhost:8081/parks';

export default {
    getParks() {
        return axios.get(API_URL);
    },
    addPark(park) {
        return axios.post(API_URL, park);
    },
    updatePark(park) {
        return axios.put(API_URL, park);
    },
    deletePark(id) {
        return axios.delete(`${API_URL}/${id}`);
    },
};
