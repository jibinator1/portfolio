import React, { useState, useEffect, useRef } from "react";
import { motion, AnimatePresence } from "framer-motion";
import "./NameTitle.css";

function NameTitle() {
  const [text, setText] = useState("Jibin Im");
  let indexRef = {current: 0};

  useEffect(() => {
    const texts = ["Invested in Data Science", "Jibin Im", "a 2nd Year Data Science Student","Invested in Machine Learning", "a Quick Learner"];

    const changeText = () => {
      setText(texts[indexRef.current]);
      indexRef.current = (indexRef.current + 1) % texts.length;
    };

    const interval = setInterval(changeText, 5000); //change every 5 secdson
    changeText(); 

    return () => clearInterval(interval);
  }, []);

  return (
    <div className="introduction">
      <motion.h1
        id="intro1"
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ duration: 1 }}
      >
        Hi, I'm{" "}
        <AnimatePresence mode="wait">
          <motion.span
            key={text}
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            exit={{ opacity: 0 }}
            transition={{ duration: 0.5, ease: "easeInOut" }}
          >
            {text}
          </motion.span>
        </AnimatePresence>
      </motion.h1>
    </div>
  );
}

export default NameTitle;