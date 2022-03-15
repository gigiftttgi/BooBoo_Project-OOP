import { useEffect, useState } from 'react';
import axios from 'axios';

<<<<<<< HEAD
const Shop = ({Antibody}) => {

  const [money, setMoney] = useState('');
  
=======

// const antibody = ;


const Shop = () => {

  const [money, setMoney] = useState('');
  const [anti, setAnti] = useState('');

  const getAnti = (data) => {

  }
  

>>>>>>> 4df2dfd1d5f7f018d65e65919ac701c94977cd2f
  const fetchMoney = async () => {
    try {
      const m = await axios('/shop/money',);
      setMoney(m.data);
      // console.log(m.data);
    } catch (err) {
      console.error(err.message);
    }
  };

  useEffect(async () => {
    fetchMoney()

    const interval = setInterval(() => {
      fetchMoney()
    }, 1000)
    return () => clearInterval(interval)


  }, []);


<<<<<<< HEAD
  function sentBuyAntiA(anti) {
    // axios.post('/shop/buyA', anti)
    //   .then(response => console.log(response.data));
    Antibody('A');
  }

  function sentBuyAntiB(anti) {
    // axios.post('/shop/buyB', anti)
    //   .then(response => console.log(response.data));
    Antibody('B');
  }

  function sentBuyAntiC(anti) {
    // axios.post('/shop/buyC', anti)
    //   .then(response => console.log(response.data));
    Antibody('C');
=======


  // function sentBuyAnti(){
  //   axios.post('/shop/setAnti', anti)
  //   .then(response => console.log(response.data));
  //   setAnti('');
  // }

  function sentBuyAntiA() {
    setAnti("antiA");
    axios.post('/shop/setAnti', "antiA")
    .then(response => console.log(response.data));
    setAnti('');

  }

  function sentBuyAntiB() {
    // setAnti("antiB");
    axios.post('/shop/setAnti', "antiB")
    .then(response => console.log(response.data));
    setAnti('');

    console.log("call B");

  }

  function sentBuyAntiC() {
    // setAnti("antiC");
    axios.post('/shop/setAnti', "antiC")
    .then(response => console.log(response.data));
    setAnti('');

>>>>>>> 4df2dfd1d5f7f018d65e65919ac701c94977cd2f
  }




  return (

    <div className="Shop">
      <div className="Shoptext">SHOP</div>
      <div className="CreditBar">
        {money} Credit
      </div>

      <div className="AntiShop">

        <div className="AntiBox">
          <div className="AntiImgBox">
            <img className="AntiImg" src={require('./image/antibody/AntibodyA.png')}></img>
          </div>
          <div className="AntiTextBox">
            <div className="AntiText">
              Antibody A <br /> HI
            </div>
            <button className='BuyBtn' onClick={() =>  
              {sentBuyAntiA()}
              } >20 Credit</button>
          </div>
        </div>

        <div className="AntiBox">
          <div className="AntiImgBox">
            <img className="AntiImg" src={require('./image/antibody/AntibodyB.png')}></img>
          </div>
          <div className="AntiTextBox">
            <div className="AntiText">
              Antibody B <br /> HI
            </div>
            <button className='BuyBtn' onClick={() => 
             {sentBuyAntiB()}

              } >30 Credit</button>
          </div>
        </div>

        <div className="AntiBox">
          <div className="AntiImgBox">
            <img className="AntiImg" src={require('./image/antibody/AntibodyC.png')} ></img>
          </div>
          <div className="AntiTextBox">
            <div className="AntiText">
              Antibody C <br /> HI
            </div>
            <button className='BuyBtn' onClick={() => 
              {sentBuyAntiC()} 
              }  >40 Credit </button>
          </div>
        </div>

      </div>

    </div>


  );

}



export default Shop;