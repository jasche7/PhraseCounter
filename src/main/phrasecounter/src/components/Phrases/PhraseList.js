import React, { useEffect, useState } from "react";

const PhraseList = (props) => {
  const url = "http://localhost:8080/phrase";
  const [res, setRes] = useState({});

  const makeRequest = (data) => {
    const response = fetch(url, {
      method: "POST",
      mode: "cors",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((result) => console.log(result));

    setRes(response);
  };

  useEffect(() => {
    if (props.active) {
      let phraseMaker = {
        text: props.phraseCount[0],
        minOccurrences: props.phraseCount[1],
        maxPhraseLength: props.phraseCount[2],
      };
      makeRequest(phraseMaker);
    }
  }, [props.phraseCount]);
  return <></>;
};

export default PhraseList;
