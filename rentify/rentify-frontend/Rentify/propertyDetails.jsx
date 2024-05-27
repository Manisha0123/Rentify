import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const PropertyDetails = () => {
  const { id } = useParams();
  const [property, setProperty] = useState(null);

  useEffect(() => {
    const fetchProperty = async () => {
      const response = await axios.get(`/api/properties/details/${id}`);
      setProperty(response.data);
    };

    fetchProperty();
  }, [id]);

  if (!property) return <div>Loading...</div>;

  const handleInterestedClick = async () => {
    try {
      const token = localStorage.getItem('token');
      await axios.post(`/api/properties/interested/${id}`, {}, {
        headers: { Authorization: `Bearer ${token}` },
      });
      alert('Seller contact details have been sent to your email');
    } catch (error) {
      console.error('Interest click error:', error);
    }
  };

  return (
    <div>
      <h1>{property.location}</h1>
      <p>{property.area} sq. ft.</p>
      <p>{property.bedrooms} bedrooms</p>
      <p>{property.bathrooms} bathrooms</p>
      <p>Nearby Hospitals: {property.nearbyHospitals}</p>
      <p>Nearby Colleges: {property.nearbyColleges}</p>
      <button onClick={handleInterestedClick}>I'm Interested</button>
    </div>
  );
};

export default PropertyDetails;
