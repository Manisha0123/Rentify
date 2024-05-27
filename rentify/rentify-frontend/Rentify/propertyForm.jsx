import React, { useState } from 'react';
import axios from 'axios';

const PropertyForm = () => {
  const [formData, setFormData] = useState({
    location: '',
    area: '',
    bedrooms: '',
    bathrooms: '',
    nearbyHospitals: '',
    nearbyColleges: '',
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const token = localStorage.getItem('token');
      await axios.post('/api/properties/add', formData, {
        headers: { Authorization: `Bearer ${token}` },
      });
      alert('Property added successfully');
    } catch (error) {
      console.error('Add property error:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Location</label>
        <input type="text" name="location" value={formData.location} onChange={handleChange} required />
      </div>
      <div>
        <label>Area (sq. ft.)</label>
        <input type="number" name="area" value={formData.area} onChange={handleChange} required />
      </div>
      <div>
        <label>Bedrooms</label>
        <input type="number" name="bedrooms" value={formData.bedrooms} onChange={handleChange} required />
      </div>
      <div>
        <label>Bathrooms</label>
        <input type="number" name="bathrooms" value={formData.bathrooms} onChange={handleChange} required />
      </div>
      <div>
        <label>Nearby Hospitals</label>
        <input type="text" name="nearbyHospitals" value={formData.nearbyHospitals} onChange={handleChange} />
      </div>
      <div>
        <label>Nearby Colleges</label>
        <input type="text" name="nearbyColleges" value={formData.nearbyColleges} onChange={handleChange} />
      </div>
      <button type="submit">Add Property</button>
    </form>
  );
};

export default PropertyForm;
