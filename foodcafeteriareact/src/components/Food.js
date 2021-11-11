import React from 'react';

const Food = ({ valor }) => {
  return (
    <div>
      <div className="col">
        <div className="card">
          <img
            src={valor.image}
            className="card-img-top"
            alt="..."
            width="30%"
          />
          <div className="card-body">
            <h5 className="card-title">{valor.name}</h5>
            <p className="card-text">{valor.description}</p>
            <a href="#" className="btn btn-primary">
              Adicionar
            </a>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Food;
