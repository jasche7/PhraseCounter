import React, { useState } from "react";
import Textbox from "../Textbox/Textbox";
import Display from "../Display/Display";
import PhraseList from "../Phrases/PhraseList";

const Layout = () => {
  const [phraseCount, setPhraseCount] = useState([]);

  return (
    <>
      <Textbox setPhraseCount={setPhraseCount} />
      <Display phraseCount={phraseCount} />
      <PhraseList />
    </>
  );
};

export default Layout;
