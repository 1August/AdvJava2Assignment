let goToList = document.querySelector(".gotoList");
let addTigerCageButton = document.querySelector(".addTigerCage");
let addBirdCell = document.querySelector('.addBirdCell')
let addAnimalForm = document.querySelector('.addAnimalForm')
let numberOfAnimals = document.querySelector('input[type="number"]')
let submitButton = document.querySelector('input[type="submit"]')

const animalsInHabitat = []

const crow = {}
const tiger = {}

const animals = []
animals.push(tiger, crow)

let addInputs = document.querySelectorAll('input[type="radio"]')

const buttons = [];
buttons.push(addTigerCageButton, addBirdCell)

// let checkedInput;
// addInputs.forEach((el, i) => {
//     el.addEventListener('click', (e) => {
//         if (el.getAttribute('checked')){
//             checkedInput = i;
//         }
//     })
// })

// submitButton.addEventListener('click', (e) => {
//     e.preventDefault()
//     animalsInHabitat.push(animals[i]);
// })



buttons.forEach((el, i) => {
    el.addEventListener('click', function(e){
        e.preventDefault()
        addLinkTo(i)
        this.style.display = 'none'
    })
})

const addLinkTo = (optionNumb) => {
    if (optionNumb === 0) {
        goToList.innerHTML += ', <a href="/places/tigerCage">Tiger cage</a>'
    } else if (optionNumb === 1) {
        goToList.innerHTML += ', <a href="/places/birdCell">Bird cage</a>'
    } else {
        console.error('Nothing happened.')
    }
}
