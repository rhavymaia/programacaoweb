import dataset from './model/dataset.js';
import food from './model/food.js';

food.load(dataset);
let foods = food.readAll();

for (const item of foods) {
  const itensDiv = document.getElementById('itens');
  const cardHTML = addItem(item);
  itensDiv.insertAdjacentHTML('beforeend', cardHTML);
}

function addItem(item){
  let cardHTML = `
    <div class='col'>
      <div class='card' style='width: 18rem;'>
        <img src='${item.image}' class='card-img-top' alt='...'>
        <div class='card-body'>
          <h5 class='card-title'>${item.name}</h5>
          <p class='card-text'>${item.description}</p>
          <a href='#' class='btn btn-primary'>Go somewhere</a>
        </div>
      </div>
    </div>`;
  return cardHTML;
}
