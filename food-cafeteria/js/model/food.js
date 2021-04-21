function load(newFoods) {
  localStorage.setItem('foods-app:foods', JSON.stringify(newFoods));
}

function readAll() {
  const stringFood = localStorage.getItem('foods-app:foods');
  return JSON.parse(stringFood);
}

export default { load, readAll };
