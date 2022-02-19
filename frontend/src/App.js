import './App.css';
import Field from './component/Field';
import Menu from './component/Menu';
import Shop from './component/Shop';

function App() {
  return (
    <div className="MainGame">
      <Shop/>
      <Field/>
      <Menu/>
    </div>
  );
}


export default App;
