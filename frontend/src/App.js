// import './App.css';
import { useEffect, useState } from 'react'; 
import {BrowserRouter as Router,Routes, Route,Link} from "react-router-dom";

import Game from './Game';
import Start from './Start'

function App() {
  
  return(
    <Router>
      <Routes>
      <Route exact path="/" element = {<Start/>}></Route>
      <Route path='/gameplay' element = {<Game/>}></Route>
    </Routes>
    </Router>
    
  );
    

}

export default App;
