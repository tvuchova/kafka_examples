package com.example.demo.kafka_demo_example.model;

public class KafkaGreeting
{
  private String msg;
  private String name;

  public KafkaGreeting()
  {

  }

  public KafkaGreeting(String msg, String name)
  {
    this.msg = msg;
    this.name = name;
  }

  public String getMsg()
  {
    return msg;
  }

  public void setMsg(String msg)
  {
    this.msg = msg;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public String toString()
  {
    return msg + ", " + name + "!";
  }
}
