import memesData from "../memesData"
import React from "react";
export default function Meme() {
    const memes = memesData.data.memes;
    const [image, setImage] =  React.useState(memes[0].url);
    
    function generateNewImage() {
        const randomIndex = Math.floor(Math.random() * memes.length)
        console.log(image)
        setImage(memes[randomIndex].url);
    }

    return (
        <div className="container">
            <input 
                type="text" placeholder="Top text" 
                className="form--input"
            />
            <input 
                type="text" placeholder="Button text" 
                className="form--input"
            />
            <button 
                className="meme--button" 
                onClick={generateNewImage}>Get a new meme image  🖼
            </button>
            <div className="meme--image--container">
                <img src={`${image}`} alt="" />
            </div>
        </div>
    )
}