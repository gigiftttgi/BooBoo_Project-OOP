import './App.css';
import Field from './component/Field';
import Menu from './component/Menu';
import Shop from './component/Shop';

function App() {
  return (
    <div className="MainGame">
      <Menu/>
      <div className="contianer">
        <Shop/>
        <Field/>
      </div>
    </div>
  );
}


export default App;
