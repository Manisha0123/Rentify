import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './api.jsx';
import './propertyList.css';

const PropertyList = () => {
  const [properties, setProperties] = useState([]);

  useEffect(() => {
    const fetchProperties = async () => {
      const response = await axios.get('/api/properties/all');
      setProperties(response.data);
    };

    fetchProperties();
  }, []);

  return (
    <div>
      <h1>Properties</h1>
      {properties.map((property) => (
        <div key={property.id}>
          <Link to={`/properties/${property.id}`}>
            <h2>{property.location}</h2>
          </Link>
          <p>{property.area} sq. ft.</p>
          <p>{property.bedrooms} bedrooms</p>
          <p>{property.bathrooms} bathrooms</p>
        </div>
      ))}
    </div>
  );
};

export default PropertyList;
