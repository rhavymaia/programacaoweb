import React from 'react';
import { useState } from 'react';

import Food from './Food';

const cafe = {
  name: 'Café',
  image: './images/cafe.jpg',
  description: 'Descrição',
};

const suco = {
  name: 'Suco',
  image: './images/suco.jpg',
  description: 'Descrição',
};

const fritas = {
  name: 'Fritas',
  image: './images/fritas.jpg',
  description: 'Descrição',
};

const dados = [cafe, suco, fritas];

const Main = () => {
  const [foods, setFoods] = useState(dados);

  const eventHandler = function () {
    const hamburguer = {
      name: 'Hamburguer',
      image: './images/hamburguer.jpg',
      description: 'Descrição',
    };

    setFoods([...foods, hamburguer]);
  };

  return (
    <>
      <h1 className="mt-5 text-center">Cardápio</h1>

      <div>
        <button
          type="button"
          name="addFood"
          className="btn btn-primary rounded-circle fw-bold"
          data-bs-toggle="modal"
          data-bs-target="#foodModal"
          onClick={eventHandler}
        >
          +
        </button>
      </div>

      <div className="row" id="itens">
        {foods.map(function (food) {
          return <Food valor={food} />;
        })}
      </div>
    </>
  );
};

export default Main;
