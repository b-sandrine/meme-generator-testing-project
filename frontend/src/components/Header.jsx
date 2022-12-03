import logo from '../assets/logo.png'
export default function Navbar() {
    return (
        <nav>
            <div className="nav--logo">
                <img src={logo} className="logo--image"/>
                <h1 className="logo--name">Meme Generator</h1>
            </div>
            <p className='nav--title'>React Course - Project 3</p>
        </nav>
    )
}